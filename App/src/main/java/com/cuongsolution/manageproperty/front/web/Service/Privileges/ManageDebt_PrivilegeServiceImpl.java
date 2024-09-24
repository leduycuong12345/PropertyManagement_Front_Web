package com.cuongsolution.manageproperty.front.web.Service.Privileges;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageDebt_PrivilegeServiceImpl implements ManageDebt_PrivilegeService{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public boolean isWorksheetBelongToUser(long worksheetId, String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/managedebt/privilege/isworksheetbelongtouser";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("worksheetId",""+ worksheetId);
		requestJson.add("username", username);
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
        
        return postMonoResponse.block();
	}

}
