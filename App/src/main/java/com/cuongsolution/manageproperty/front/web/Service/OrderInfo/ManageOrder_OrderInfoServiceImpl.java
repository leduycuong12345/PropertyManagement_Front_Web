package com.cuongsolution.manageproperty.front.web.Service.OrderInfo;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_OrderDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageOrder_OrderInfoServiceImpl implements ManageOrder_OrderInfoService {
	Logger logger = LoggerFactory.getLogger(ManageOrder_OrderInfoServiceImpl.class);
	
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	
	@Override
	public List<ManageOrder_OrderDTO> getOrderList_ManageOrder(
			long landID, LocalDate selectedDate) {
		String fullPostURL = kafkaBaseURL+"/manageorder/getorderlist";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("landID", ""+landID);
		requestJson.add("selectedDate", ""+selectedDate);
		Mono<List<ManageOrder_OrderDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageOrder_OrderDTO.class);
		logger.info("order list of land id:"+landID+ " by date : "+selectedDate +" and result: "+postMonoResponse.block());
		return postMonoResponse.block();
	}

	@Override
	public void deleteOrder_ManageOrder(long orderID) {
		String fullPostURL = kafkaBaseURL+"/manageorder/deteleorder";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("orderID", ""+orderID);
		Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
		postMonoResponse.block();
	}

	@Override
	public void hardDeleteOrder_ManageOrder(long orderID) {
		String fullPostURL = kafkaBaseURL+"/manageorder/harddeteleorder";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("orderID", ""+orderID);
		Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
		postMonoResponse.block();
		
	}
	
}
