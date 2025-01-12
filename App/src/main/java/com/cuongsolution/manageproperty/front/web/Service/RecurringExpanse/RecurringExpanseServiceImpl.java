package com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_CreateRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_EditRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_RecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ExpanseHeaderDTO; 
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;
@Service
public class RecurringExpanseServiceImpl implements RecurringExpanseService {
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public List<ManageOrder_ExpanseHeaderDTO> manageOrder_findRecurringExpanseBelongToLand(long landID) {
		String fullPostURL = kafkaBaseURL+"/manageorder/findrecurringexpansebelongtoland";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		Mono<List<ManageOrder_ExpanseHeaderDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageOrder_ExpanseHeaderDTO.class);
		return postMonoResponse.block();
	}

	@Override
	public List<ManageExpanse_RecurringExpanseDTO> manageExpanse_findRecurringExpanseBelongToLand(long landID) {
		String fullPostURL = kafkaBaseURL+"/manageexpanse/findrecurringexpansebelongtoland";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		Mono<List<ManageExpanse_RecurringExpanseDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageExpanse_RecurringExpanseDTO.class);
		return postMonoResponse.block();
	}

	@Override
	public void manageExpanse_deleteByID(long recurringExpanseID) {
		String fullPostURL = kafkaBaseURL+"/manageexpanse/deletebyid";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("recurringExpanseID", ""+recurringExpanseID);
		Mono<String> postMonoResponse = apiCaller.post(fullPostURL, requestJson, String.class);
		postMonoResponse.block();
	}

	@Override
	public void manageExpanse_editExpanseDTO(ManageExpanse_EditRecurringExpanseDTO editRecurringExpanseDTO) {
		String fullPostURL = kafkaBaseURL+"/manageexpanse/editrecurringexpanse";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri("/manageexpanse/editrecurringexpanse")
                .bodyValue(editRecurringExpanseDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.subscribe(response -> {
            System.out.println("Response from server: " + response);
        });
	}

	@Override
	public void manageExpanse_createRecurringExpanse(ManageExpanse_CreateRecurringExpanseDTO newExpanseDTO) {
		String fullPostURL = kafkaBaseURL+"/manageexpanse/createrecurringexpanse";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri("/manageexpanse/createrecurringexpanse")
                .bodyValue(newExpanseDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.subscribe(response -> {
            System.out.println("Response from server: " + response);
        });
	}

}
