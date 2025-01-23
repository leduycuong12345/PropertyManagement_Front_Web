package com.cuongsolution.manageproperty.front.web.Service.Parameter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ParameterServiceImpl implements ParameterService {
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public boolean checkCurrentDate(int selectedMonth, int selectedYear) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/parameterservice/checkcurrentdate";
		LinkedMultiValueMap<String, String> requestJson = 
						new LinkedMultiValueMap<String, String>();
		requestJson.add("selectedMonth", ""+selectedMonth);
		requestJson.add("selectedYear", ""+selectedYear);
		Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
		return postMonoResponse.block();
	}
	

}
