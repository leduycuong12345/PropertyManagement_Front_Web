package com.cuongsolution.manageproperty.front.web.Service.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_AddTenantToWorksheetDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;
@Service
public class TenantServiceImpl implements TenantService{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void addTenantToWorksheet_ManageProperty(ManageProperty_AddTenantToWorksheetDTO newTenantDTO) {
		String fullPostURL = kafkaBaseURL+"/managetenant/addtenanttoworksheet";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri("/managetenant/addtenanttoworksheet")
                .bodyValue(newTenantDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
	}

}
