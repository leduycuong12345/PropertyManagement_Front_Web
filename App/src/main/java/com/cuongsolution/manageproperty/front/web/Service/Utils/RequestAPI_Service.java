package com.cuongsolution.manageproperty.front.web.Service.Utils;


import reactor.core.publisher.Mono;


public interface RequestAPI_Service {
	public abstract  <T> Mono<T> get(String url, Class<T> responseType);

	public abstract <T, R> Mono<T> post(String url, R requestBody, Class<T> responseType);
}
