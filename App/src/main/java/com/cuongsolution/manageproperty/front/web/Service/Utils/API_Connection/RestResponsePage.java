package com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class RestResponsePage<T> extends PageImpl<T> {


	private static final long serialVersionUID = 461953186940153061L;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestResponsePage(@JsonProperty("content") List<T> content, @JsonProperty("number") int number, @JsonProperty("size") int size,
                    @JsonProperty("totalElements") Long totalElements, @JsonProperty("pageable") JsonNode pageable, @JsonProperty("last") boolean last,
                    @JsonProperty("totalPages") int totalPages, @JsonProperty("sort") JsonNode sort, @JsonProperty("first") boolean first,
                    @JsonProperty("numberOfElements") int numberOfElements) {
        super(content, PageRequest.of(number, size), totalElements);
    }
	
	
    public RestResponsePage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public RestResponsePage(List<T> content) {
        super(content);
    }
    // Default constructor (for deserialization)
    public RestResponsePage() {
        super(Collections.emptyList());
    }
    public Page<T> getPageableObjectType()
    {
    	int pageSize = this.getTotalPages();
    	long pageOffset = this.getNumber();
    	long total = pageOffset + this.getSize() + (this.getSize() == pageSize ? pageSize : 0);
    	Page<T> page = new PageImpl<T>(this.getContent(), this.getPageable(),total);
    	return page;
    }
}