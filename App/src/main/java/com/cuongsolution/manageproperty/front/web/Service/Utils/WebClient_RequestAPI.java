package com.cuongsolution.manageproperty.front.web.Service.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class WebClient_RequestAPI implements RequestAPI_Service{
	 private final WebClient webClient;

	    public WebClient_RequestAPI() {
	        this.webClient = WebClient.create();
	    }

	    @Override
	    public <T> Mono<T> get(String url, Class<T> responseType) {
	          Mono<T> result = webClient.get()
	                                    .uri(url)
	                                    .retrieve()
	                                    .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
	                                        if (clientResponse.statusCode().equals(HttpStatus.UNAUTHORIZED)) {
	                                            // Handle 401 Unauthorized
	                                            return Mono.error(new RuntimeException("Unauthorized - 401"));
	                                        } else if (clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)) {
	                                            // Handle 404 Not Found
	                                            return Mono.error(new RuntimeException("Resource not found - 404"));
	                                        } else {
	                                            // Handle other 4xx errors
	                                            return Mono.error(new RuntimeException("Client error: " + clientResponse.statusCode()));
	                                        }
	                                    })
	                                    .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
	                                        // Handle 5xx Server errors
	                                        return Mono.error(new RuntimeException("Server error: " + clientResponse.statusCode()));
	                                    })
	                                    .bodyToMono(responseType);
	          return result;
	    }
	    @Override
	    public <T, R> Mono<T> post(String url, R requestBody, Class<T> responseType) {
	    	Mono<T> result = webClient.post()
	                                    .uri(url)
	                                    .contentType(MediaType.APPLICATION_JSON)
	                                    .bodyValue(requestBody)
	                                    .retrieve()
	                                    .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
	                                        if (clientResponse.statusCode().equals(HttpStatus.UNAUTHORIZED)) {
	                                            // Handle 401 Unauthorized
	                                            return Mono.error(new RuntimeException("Unauthorized - 401"));
	                                        } else if (clientResponse.statusCode().equals(HttpStatus.NOT_FOUND)) {
	                                            // Handle 404 Not Found
	                                            return Mono.error(new RuntimeException("Resource not found - 404"));
	                                        } else {
	                                            // Handle other 4xx errors
	                                            return Mono.error(new RuntimeException("Client error: " + clientResponse.statusCode()));
	                                        }
	                                    })
	                                    .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
	                                        // Handle 5xx Server errors
	                                        return Mono.error(new RuntimeException("Server error: " + clientResponse.statusCode()));
	                                    })
	                                    .bodyToMono(responseType);
	        return result;
	    }

}
