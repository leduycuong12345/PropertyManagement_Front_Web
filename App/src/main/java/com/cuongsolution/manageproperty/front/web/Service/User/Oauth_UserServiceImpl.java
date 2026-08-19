package com.cuongsolution.manageproperty.front.web.Service.User;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.OAuth2_GmailRegister_UserDTO;
import com.cuongsolution.manageproperty.front.web.DTO.Oauth_UserDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class Oauth_UserServiceImpl implements Oauth_UserService{
	private Logger logger = LoggerFactory.getLogger(Oauth_UserServiceImpl.class);
	
	@Value("${cuongsolution.manageproperty.userservice.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public Oauth_UserDTO getUserByGmail_OAuth2(String email) {
		String fullPostURL = kafkaBaseURL+"/oauthservice/finduserbygmail";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("email", ""+email);
        Mono<Oauth_UserDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Oauth_UserDTO.class);
        
        return postMonoResponse.block();
	}

	@Override
	public boolean createUserByGmail_OAuth2(OAuth2_GmailRegister_UserDTO user) {
		String fullPostURL = kafkaBaseURL+"/oauthservice/createnewuser";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		 
		
		logger.info("Oauth_UserServiceImpl createUserByGmail_OAuth2 with username"+user.getUsername() +" email:"+user.getEmail()
		);
		requestJson.add("username", user.getUsername());
		requestJson.add("lastName", user.getLastName());
		requestJson.add("email", user.getEmail());
		requestJson.add("providerName", user.getProviderName());
		requestJson.add("providerId", user.getProviderId());
		
		
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);        
        //Boolean
        return postMonoResponse.block();
	}


}
