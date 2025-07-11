package com.cuongsolution.manageproperty.front.web.Service.PropertyService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditFastRecurringExpanseListDTO;

import reactor.core.publisher.Mono;
@Service
public class PropertyServiceSerImp implements PropertyServiceSer {
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Override
	public void fastEditExpanseList(ManageProperty_EditFastRecurringExpanseListDTO editFastExpanseList) {
		String fullPostURL = kafkaBaseURL+"/manageproperty/fasteditexpanselist";
		// Create a WebClient instance
		WebClient webClient = WebClient.create(kafkaBaseURL);
		// Perform the POST request
        Mono<String> responseMono = webClient.post()
                .uri(fullPostURL)
                .bodyValue(editFastExpanseList) // Send the list of Product objects
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to get the response
        responseMono.block();
	}

}
