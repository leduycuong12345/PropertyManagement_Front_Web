package com.cuongsolution.manageproperty.front.web.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.cuongsolution.manageproperty.front.web.Service.Security.UserDetailsServiceImpl;

import java.util.Arrays;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
		return new MvcRequestMatcher.Builder(introspector).servletPath("/spring-mvc");
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//cors to send GET request to google geocode api
		http.cors((cors) -> cors
				.configurationSource(myGoogleGeoAPIConfigurationSource())
			);
		//end cors to send GET request to google geocode api
		//csrf token 
		http
		.csrf((csrf) -> csrf
			.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
		);
		//khong yeu cau dang nhap voi URI
		/*http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/api/manage/edit-property")
				.permitAll()
			);*/
		//yeu cau dang nhap vs URI
		
		  http.authorizeHttpRequests((authorize) -> authorize
				  .requestMatchers("/register","/register/**").permitAll()
				  .anyRequest().authenticated()
				  );
		
		//login logout
		http
		.formLogin((form) -> form .loginPage("/login") // somehow this line
				.defaultSuccessUrl("/quan-ly").permitAll()
				)
		.logout((logout)
		 -> logout.logoutUrl("/logout").permitAll());		 
		return http.build();
    }
	
	//cors to send GET request to google geocode API
	CorsConfigurationSource myGoogleGeoAPIConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		//configuration.setAllowedOrigins(Arrays.asList("https://localhost:8080")); // Add your frontend origin
		configuration.setAllowedOrigins(Arrays.asList("https://quanlytaisan.site","https://localhost:8080")); // Add your frontend origin
		configuration.setAllowedMethods(Arrays.asList("GET","POST","HEAD"));
		configuration.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	// END cors to send GET request to google geocode API
	@Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
	}


}
