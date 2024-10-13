package com.cuongsolution.manageproperty.front.web.Service.OrderInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_OrderDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RestResponsePage;

import reactor.core.publisher.Mono;

@Service
public class ManageDebt_OrderInfoServiceImpl implements ManageDebt_OrderInfoService{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public void deleteOrder_ManageDebt(long orderID) {
		String fullPostURL = kafkaBaseURL+"/managedebt/deleteorder";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("orderID", ""+orderID);
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
        
        postMonoResponse.block();
	}
	@Override
	public void hardDeleteOrder_ManageDebt(long orderID) {
		String fullPostURL = kafkaBaseURL+"/managedebt/harddeleteorder";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("orderID", ""+orderID);
        Mono<Boolean> postMonoResponse = apiCaller.post(fullPostURL, requestJson, Boolean.class);
        
        postMonoResponse.block();
	}
	@Override
	public Page<ManageDebt_OrderDTO> getDebtList_BelongToWorksheet_ManageDebt(long worksheetId,Pageable pageable) 
	{
		
		String fullPostURL = kafkaBaseURL+"/managedebt/getdebtlistbelongtoworksheet";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("page", ""+pageable.getPageNumber());
		requestJson.add("size", ""+pageable.getPageSize());
		requestJson.add("worksheetId", ""+worksheetId);
		Mono<RestResponsePage<ManageDebt_OrderDTO>> postMonoResponse = this.apiCaller.post_PageResult(fullPostURL, requestJson, ManageDebt_OrderDTO.class);

        return postMonoResponse.block().getPageableObjectType();
	}
	@Override
	public Page<ManageDebt_OrderDTO> getDebtList_BelongToLand_ManageDebt_Pageable(long landID, int selectedPage,
			int totalRowPerPage) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<ManageDebt_OrderDTO> getDebtList_BelongToLand_ManageDebt_PageableAndSorting(long landID,
			int selectedPage, int totalRowPerPage, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<ManageDebt_OrderDTO> getDebtList_BelongToWorksheet_ManageDebt_Pageable(long worksheetId,
			Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}