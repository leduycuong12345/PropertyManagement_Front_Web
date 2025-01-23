package com.cuongsolution.manageproperty.front.web.Service.Property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_PropertyDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditPropertyDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_PropertyDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;
@Service
public class ManageProperty_PropertyServiceImp implements ManageProperty_PropertySer{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void createProperty(String propertyName, double propertyRentalPrice, Long landID) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/createproperty";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		requestJson.add("propertyRentalPrice", ""+propertyRentalPrice);
		requestJson.add("propertyName", ""+propertyName);
		Mono<String> postMonoResponse = apiCaller.post(fullPostURL, requestJson, String.class);
		postMonoResponse.block();
	}

	@Override
	public void deleteById(long propertyID) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/deletebyid";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("propertyID", ""+propertyID);
		Mono<String> postMonoResponse = apiCaller.post(fullPostURL, requestJson, String.class);
		postMonoResponse.block();
	}

	@Override
	public List<ManageProperty_PropertyDTO> getPropertyBelongToLand_ManageProperty(long landID) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/getpropertybelongtoland";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		Mono<List<ManageProperty_PropertyDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageProperty_PropertyDTO.class);
		return postMonoResponse.block();
	}

	@Override
	public void editProperty_ManageProperty(ManageProperty_EditPropertyDTO propertyDTO) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/editproperty";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri("/manageproperty/editproperty")
                .bodyValue(propertyDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
		
	}

	@Override
	public void editPropertyIncludedWorksheet(ManageProperty_PropertyDTO propertyDTO) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/editpropertyincludedworksheet";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri("/manageproperty/editpropertyincludedworksheet")
                .bodyValue(propertyDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
	}

	@Override
	public List<ManageExpanse_PropertyDTO> manageExpanse_createExpanse_getPropertyListBelongToLand(long landID) {
		String fullPostURL = kafkaBaseURL+"/manageexpanse/getpropertybelongtoland";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		Mono<List<ManageExpanse_PropertyDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageExpanse_PropertyDTO.class);
		return postMonoResponse.block();
	}

}
