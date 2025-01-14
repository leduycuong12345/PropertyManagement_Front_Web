package com.cuongsolution.manageproperty.front.web.Service.Property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.ManageTenant_PropertyDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageTenant_PropertySerImpl implements ManageTenant_PropertySer{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public List<ManageTenant_PropertyDTO> getPropertyListIncludedTenantsByLandId(Long landID) {
		String fullPostURL = kafkaBaseURL+"/managetenant/getpropertylistincludedtenantsbylandid";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		Mono<List<ManageTenant_PropertyDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageTenant_PropertyDTO.class);
		return postMonoResponse.block();
	}

}