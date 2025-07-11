package com.cuongsolution.manageproperty.front.web.Service.Tenant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuongsolution.manageproperty.front.web.DTO.ManageTenant_EditTenant_TenantDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;
@Service
public class ManageTenant_TenantServiceImpl implements ManageTenant_TenantService {
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void editTenant_ManageTenant(ManageTenant_EditTenant_TenantDTO tenantDTO) {
		String fullPostURL = kafkaBaseURL+"/managetenant/edittenant";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri(fullPostURL)
                .bodyValue(tenantDTO) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
	}

}
