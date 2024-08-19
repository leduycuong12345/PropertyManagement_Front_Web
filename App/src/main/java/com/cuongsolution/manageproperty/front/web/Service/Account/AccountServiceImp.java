package com.cuongsolution.manageproperty.front.web.Service.Account;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cuongsolution.manageproperty.front.web.DTO.AccountDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class AccountServiceImp implements AccountService {
	
	@Value("${cuongsolution.manageproperty.front.web.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public AccountDTO findByUsername(String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/userserivce/findbyusername?username="+username;
        String requestJson = "{\"account_ID\":\"username\", \"password\":\"bar\", \"userId\":1}";
        Mono<AccountDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, AccountDTO.class);
        
        AtomicBoolean errorOccurred = new AtomicBoolean(false);
        postMonoResponse.doOnError(error -> errorOccurred.set(true))
        .subscribe(response -> {
            System.out.println("Response received: " + response);
        }, error -> {
            System.err.println("Error: " + error.getMessage());
        });
        if(errorOccurred.get())
        {
        	return postMonoResponse.block();
        }
        else
        {
        	return new AccountDTO();
        }
	}


	@Override
	public AccountDTO findByUsername_Production(String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/userserivce/findbyusername?username="+username;
		String requestJson = "{\"account_ID\":\"username\", \"password\":\"bar\", \"userId\":1}";
		Mono<AccountDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, AccountDTO.class);
		        
		AtomicBoolean errorOccurred = new AtomicBoolean(false);
		postMonoResponse.doOnError(error -> errorOccurred.set(true))
		        .subscribe(response -> {
		            System.out.println("Response received: " + response);
		        }, error -> {
		            System.err.println("Error: " + error.getMessage());
		        });
		if(errorOccurred.get())
		{
		  	return postMonoResponse.block();
		}
		else
		{
		    return new AccountDTO();
		}
	}


}