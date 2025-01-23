package com.cuongsolution.manageproperty.front.web.Service.Contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageTenant_ContractServiceImp implements ManageTenant_ContractService{

	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void manageTenant_DeleteContractForTenantByContractID(long contractID) {
		String fullPostURL = kafkaBaseURL+"/managetenant/deletecontractfortenantbycontractid";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("contractID",""+ contractID);
        Mono<String> postMonoResponse = apiCaller.post(fullPostURL, requestJson, String.class);
        
        postMonoResponse.block();
	}

}
