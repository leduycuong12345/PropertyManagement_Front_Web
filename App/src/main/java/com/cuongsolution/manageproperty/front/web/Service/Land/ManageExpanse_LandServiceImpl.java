package com.cuongsolution.manageproperty.front.web.Service.Land;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import com.cuongsolution.manageproperty.front.web.Model.API.Land;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageExpanse_LandServiceImpl implements ManageExpanse_LandService{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public Land findById(long LandID) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/manageexpanse/land/findlandbyid";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("LandID", ""+LandID);
        Mono<Land> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Land.class);
        
        return postMonoResponse.block();
	}

}
