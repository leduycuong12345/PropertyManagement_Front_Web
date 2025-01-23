package com.cuongsolution.manageproperty.front.web.Service.Receipt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ReceiptDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.API_Connection.RequestAPI_Service;

import reactor.core.publisher.Mono;
@Service
public class ManageDebt_ReceiptServiceImpl implements ManageDebt_ReceiptService {
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void createReceipt_ManageDebt(ManageOrder_ReceiptDTO newReceipt) {
		String fullPostURL = kafkaBaseURL+"/managedebt/receipt/createreceipt";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("orderID",""+ newReceipt.getOrderID());
		requestJson.add("receiptNote", newReceipt.getReceiptNote());
		requestJson.add("receiptAmount",""+ newReceipt.getReceiptAmount());
		requestJson.add("receiptType",""+ newReceipt.getReceiptType());
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
        
        postMonoResponse.block();
	}
}
