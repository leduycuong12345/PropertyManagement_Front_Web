package com.cuongsolution.manageproperty.front.web.Service.RecurringExpanseUnit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_RecurringExpanseUnitDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class RecurringExpanseUnitServiceImpl implements RecurringExpanseUnitService {

	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public List<ManageExpanse_RecurringExpanseUnitDTO> findAll_ManageExpanse() {
		String fullPostURL = kafkaBaseURL+"/managerecurringexpanse/findallrecurringexpanseunit";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		Mono<List<ManageExpanse_RecurringExpanseUnitDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageExpanse_RecurringExpanseUnitDTO.class);
		return postMonoResponse.block();
	}

}
