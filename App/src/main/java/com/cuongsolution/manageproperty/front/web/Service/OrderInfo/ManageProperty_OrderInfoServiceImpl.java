package com.cuongsolution.manageproperty.front.web.Service.OrderInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateOrderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_DepositDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_FastCreateOrderListDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageProperty_OrderInfoServiceImpl implements ManageProperty_OrderInfoService{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void createOrder_ManageProperty(ManageProperty_CreateOrderDTO newOrder) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/createorder";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("orderCreateDate", ""+newOrder.getOrderCreateDate());
		requestJson.add("orderExpireDate", ""+newOrder.getOrderExpireDate());
		requestJson.add("totalCost", ""+newOrder.getTotalCost());
		requestJson.add("totalDay", ""+newOrder.getTotalDay());
		requestJson.add("totalMonth", ""+newOrder.getTotalMonth());
		requestJson.add("isExpanseType", ""+newOrder.isExpanseType());
		requestJson.add("expanseCost", ""+newOrder.getExpanseCost());
		requestJson.add("expanseDetails", ""+newOrder.getExpanseDetails());
		requestJson.add("orderBelongMonth", ""+newOrder.getOrderBelongMonth());
		requestJson.add("worksheetID", ""+newOrder.getWorksheetID());
		Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
		postMonoResponse.block();
	}

	@Override
	public void createFastOrderList_ManageProperty(ManageProperty_FastCreateOrderListDTO newOrderList) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/createfastorderlist";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri(fullPostURL)
                .bodyValue(newOrderList) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
	}

	@Override
	public void createOrderForDeposit_ManageProperty(ManageProperty_DepositDTO depositDTO) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/createorderfordeposit";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri(fullPostURL)
                .bodyValue(depositDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
		
	}
	
}
