package com.cuongsolution.manageproperty.front.web.Service.Utils;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface RequestAPI_Service {
	public abstract  <T> Mono<T> get(String url, Class<T> responseType);

	public abstract <T> Mono<T> post(String url, MultiValueMap<String,
			String> requestBody, Class<T> responseType);
	public abstract  <T> Mono<List<T>> getListResult(String url, Class<T> responseType);

	public abstract <T> Mono<List<T>> postListResult(String url, MultiValueMap<String,
			String> requestBody, Class<T> responseType);

	public abstract <T> Mono<List<T>> postList_ReturnListResult(String url, List<T> requestBody, Class<T> responseType);

	public abstract <T> Mono<RestResponsePage<T>> post_PageResult(String url, MultiValueMap<String,
					String> requestBody, Class<T> responseType);
}
