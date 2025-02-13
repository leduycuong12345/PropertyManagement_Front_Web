package com.cuongsolution.manageproperty.front.web.Service.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.Register_UserDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;


@Service
public class Register_UserServiceImpl implements Register_UserService{
	private Logger logger = LoggerFactory.getLogger(Register_UserServiceImpl.class);
	
	@Value("${cuongsolution.manageproperty.userservice.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public boolean existsByEmail(String email) {
		// POST request
		
		String fullPostURL = kafkaBaseURL+"/userserivce/isexistbyemail";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("email", email);
		
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
        
        return postMonoResponse.block();
	}

	@Override
	public boolean existsByPhoneNumber(String phoneNumber) {
		String fullPostURL = kafkaBaseURL+"/userserivce/isexistbyphonenumber";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("phoneNumber", phoneNumber);
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
        
        return postMonoResponse.block();
	}

	@Override
	public void createNewUser(Register_UserDTO user) {
		String fullPostURL = kafkaBaseURL+"/userserivce/createnewuser";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		 
		
		String encryptedPassword=passwordEncoder.encode(user.getPassword());//by default s BCryptPasswordEncoder it may change in future
		logger.info("register user with id"+user.getUsername() +" pass(still not encode):"+user.getPassword()
		+" and pass(encoded):"+encryptedPassword);
		
		requestJson.add("username", user.getUsername());
		requestJson.add("password", encryptedPassword);
		requestJson.add("firstName", user.getFirstName());
		requestJson.add("lastName", user.getLastName());
		requestJson.add("email", user.getEmail());
		requestJson.add("phoneNumber", user.getPhoneNumber());
		
		
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);        
        //Boolean
        postMonoResponse.block();

	}
}
