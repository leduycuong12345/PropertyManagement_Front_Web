package com.cuongsolution.manageproperty.front.web.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cuongsolution.manageproperty.front.web.Service.Security.UserDetailsServiceImpl;
import com.cuongsolution.manageproperty.front.web.Service.Security.OauthService.CustomOAuth2UserService;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
	@Autowired
	private CustomOAuth2UserService customOAuth2UserService;
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*
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
		//yeu cau dang nhap vs URI
		
		  http.authorizeHttpRequests((authorize) -> authorize
				  .requestMatchers("/register","/register/**").permitAll()
				  .anyRequest().authenticated()
				  );
		
		//login logout
		http
		.formLogin((form) -> form .loginPage("/login") // somehow this line
				.defaultSuccessUrl("/quan-ly",true).permitAll()
				)
		.logout((logout)
		 -> logout.logoutUrl("/logout").permitAll());		 
		return http.build();
		*/
		//cors to send GET request to google geocode api
		http.cors((cors) -> cors
				.configurationSource(myCORS_ConfigurationSource())
			);
		//csrf
        http
		.csrf((csrf) -> csrf
			.csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
		);
    	
    	//end csrf
    	
    	http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/register","/login", "/error", "/webjars/**").permitAll()
            .anyRequest().authenticated()
        )
        .oauth2Login(oauth2 -> oauth2
        		.loginPage("/login")
        	    .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
        	    .defaultSuccessUrl("/quan-ly", true)
        );
    	return http.build();
    }
	
	//cors to send GET request to google geocode API
	CorsConfigurationSource myCORS_ConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		//configuration.setAllowedOrigins(Arrays.asList("https://localhost:8080")); // Add your frontend origin
		configuration.setAllowedOrigins(Arrays.asList("https://hyderson.vn","https://localhost:8080")); // Add your frontend origin
		//configuration.setAllowedOrigins(Arrays.asList("*")); // Add your frontend origin
		configuration.setAllowedMethods(Arrays.asList("GET","POST","HEAD", "DELETE", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Content-Type","Authorization"));
		//configuration.setAllowCredentials(true);
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
	    return new BCryptPasswordEncoder();
	}
	

}
