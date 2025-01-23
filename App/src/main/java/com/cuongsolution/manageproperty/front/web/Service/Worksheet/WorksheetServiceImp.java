package com.cuongsolution.manageproperty.front.web.Service.Worksheet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;


import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_BookDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateWorksheetDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageWorksheet_WorksheetDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class WorksheetServiceImp implements WorksheetService {
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void createWorksheet_At_ManageProperty(ManageProperty_CreateWorksheetDTO worksheetDTO) {
		String fullPostURL = kafkaBaseURL+"/manageworksheet/createworksheet";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri("/manageworksheet/createworksheet")
                .bodyValue(worksheetDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
	}

	@Override
	public void bookProperty_At_ManageProperty(ManageProperty_BookDTO bookDTO) {
		String fullPostURL = kafkaBaseURL+"/manageworksheet/bookproperty";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri("/manageworksheet/bookproperty")
                .bodyValue(bookDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
	}

	@Override
	public void deleteWorksheet(long worksheetID) {
		String fullPostURL = kafkaBaseURL+"/manageworksheet/deleteworksheet";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("worksheetID",""+ worksheetID);
        Mono<String> postMonoResponse = apiCaller.post(fullPostURL, requestJson, String.class);
        
        postMonoResponse.block();
	}

	@Override
	public List<ManageWorksheet_WorksheetDTO> findAllBelongToLandID(long landID) {
		String fullPostURL = kafkaBaseURL+"/manageworksheet/findworksheetbelongtoland";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		Mono<List<ManageWorksheet_WorksheetDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageWorksheet_WorksheetDTO.class);
		return postMonoResponse.block();
	}

	@Override
	public void dropPrePaid_manageProperty(long worksheetID) {
		String fullPostURL = kafkaBaseURL+"/manageworksheet/dropprepaid";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("worksheetID", ""+worksheetID);
		Mono<String> postMonoResponse = apiCaller.post(fullPostURL, requestJson, String.class);
		postMonoResponse.block();
	}

	@Override
	public void checkinProperty_manageProperty(long worksheetID) {
		String fullPostURL = kafkaBaseURL+"/manageworksheet/checkinproperty";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("worksheetID", ""+worksheetID);
		Mono<String> postMonoResponse = apiCaller.post(fullPostURL, requestJson, String.class);
		postMonoResponse.block();
		
	}


	
	
	

}

