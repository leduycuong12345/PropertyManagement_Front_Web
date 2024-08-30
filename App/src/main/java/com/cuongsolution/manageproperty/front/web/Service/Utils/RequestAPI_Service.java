package com.cuongsolution.manageproperty.front.web.Service.Utils;


import org.springframework.util.MultiValueMap;

import reactor.core.publisher.Mono;


public interface RequestAPI_Service {
	public abstract  <T> Mono<T> get(String url, Class<T> responseType);

	public abstract <T> Mono<T> post(String url, MultiValueMap<String, String> requestBody, Class<T> responseType);
}
