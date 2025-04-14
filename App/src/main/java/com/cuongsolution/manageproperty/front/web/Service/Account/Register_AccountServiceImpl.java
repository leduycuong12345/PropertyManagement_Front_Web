package com.cuongsolution.manageproperty.front.web.Service.Account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class Register_AccountServiceImpl implements Register_AccountService{
	@Value("${cuongsolution.manageproperty.userservice.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public boolean existsByUsername(String username) {		
		// POST request
		String fullPostURL = kafkaBaseURL+"/userservice/register_existsbyusername";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("username", username);
		Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
		        
		return postMonoResponse.block();
	}

}
