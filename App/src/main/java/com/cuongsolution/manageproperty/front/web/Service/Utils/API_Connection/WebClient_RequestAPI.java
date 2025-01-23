package com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
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
	    public <T> Mono<T> post(String url, MultiValueMap<String, String> requestBody, Class<T> responseType) {
	    	Mono<T> result = webClient.post()
	                                    .uri(url)
	                                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
	                                    .accept(MediaType.APPLICATION_JSON)
	                                    //.bodyValue(requestBody)
	                                    .body(BodyInserters.fromFormData(requestBody))
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
		public <T> Mono<List<T>> getListResult(String url, Class<T> responseType) {
			Mono<List<T>> result = webClient.get()
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
	                 .bodyToFlux(responseType)
	                 .collectList();

	          return result;
		}

		@Override
		public <T> Mono<List<T>> postListResult(String url, MultiValueMap<String, String> requestBody, Class<T> responseType) {
			Mono<List<T>> result = webClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .accept(MediaType.APPLICATION_JSON)
                    //.bodyValue(requestBody)
                    .body(BodyInserters.fromFormData(requestBody))
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
                    .bodyToFlux(responseType)
	                .collectList();
			return result;
		}

		@Override
		public <T> Mono<List<T>> postList_ReturnListResult(String url, List<T> requestBody,
				Class<T> responseType) {
			Mono<List<T>> result = webClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .accept(MediaType.APPLICATION_JSON)
                    //.bodyValue(requestBody)
                    .body(Mono.just(requestBody), List.class)
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
                    .bodyToFlux(responseType)
	                .collectList();
			return result;
		}

		@Override
		public <T> Mono<RestResponsePage<T>> post_PageResult(String url, MultiValueMap<String, String> requestBody,
				Class<T> responseType) {
			Mono<RestResponsePage<T>> result = webClient.post()
                    .uri(url)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .accept(MediaType.APPLICATION_JSON)
                    //.bodyValue(requestBody)
                    .body(BodyInserters.fromFormData(requestBody))
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
                    .bodyToMono(new ParameterizedTypeReference<RestResponsePage<T>>() {});
			return result;
		}

}
