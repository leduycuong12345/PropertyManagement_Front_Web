package com.cuongsolution.manageproperty.front.web.Service.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.UserInfo_AccountDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class AccountServiceImp implements AccountService {
	
	@Value("${cuongsolution.manageproperty.userservice.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public UserInfo_AccountDTO findByUsername(String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/userservice/findbyusername";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("username", username);
        Mono<UserInfo_AccountDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, UserInfo_AccountDTO.class);
        
        return postMonoResponse.block();
	}


	@Override
	public UserInfo_AccountDTO findByUsername_Production(String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/userserivce/findbyusername";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("username", username);
		Mono<UserInfo_AccountDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, UserInfo_AccountDTO.class);
		        
		
		return postMonoResponse.block();
	}


}
