package com.cuongsolution.manageproperty.front.web.Service.Land;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.UserInfo_AccountDTO;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageNavigation_LandServiceImpl_Production implements ManageNavigation_LandService_Production{
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;
	@Override
	public List<ManageNavigation_FastCreateLandDTO> getDetailsLandList_ManageNavigation_Production(String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/managenavigation/land/getlandlistbyusername";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("username", ""+username);
		Mono<List<ManageNavigation_FastCreateLandDTO>> postMonoResponse = apiCaller.postListResult(fullPostURL, requestJson, ManageNavigation_FastCreateLandDTO.class);
		return postMonoResponse.block();
			
	}

	@Override
	public void createLand_ManageNavigation_Production(ManageNavigation_FastCreateLandDTO landDTO, String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/managenavigation/createland";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("landName",landDTO.getLandName() );
		requestJson.add("orderCreationDate", ""+landDTO.getOrderCreationDate());
		requestJson.add("floorCount", ""+landDTO.getFloorCount());
		requestJson.add("propertyCountEachFloor",""+ landDTO.getPropertyCountEachFloor());
		requestJson.add("waterExpanseType",""+ landDTO.getWaterExpanseType());
		requestJson.add("electricExpanseType",""+ landDTO.getElectricExpanseType());
		requestJson.add("trashExpanseType", ""+landDTO.getTrashExpanseType());
		requestJson.add("ethernetExpanseType", ""+landDTO.getEthernetExpanseType());
		requestJson.add("propertyRentalPrice", ""+landDTO.getPropertyRentalPrice());
		requestJson.add("tenantMax", ""+landDTO.getTenantMax());
		requestJson.add("landAddress", landDTO.getLandAddress());
		requestJson.add("landAddressRegion", landDTO.getLandAddressRegion());
		requestJson.add("landAddressPostcode", landDTO.getLandAddressPostcode());
		requestJson.add("countryCode", landDTO.getCountryCode());
		requestJson.add("landLat", ""+landDTO.getLandLat());
		requestJson.add("landLng", ""+landDTO.getLandLng());
		requestJson.add("username", ""+username);
		Mono<ManageNavigation_FastCreateLandDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, ManageNavigation_FastCreateLandDTO.class);
				        
				AtomicBoolean errorOccurred = new AtomicBoolean(false);
				postMonoResponse.doOnError(error -> errorOccurred.set(true))
				        .subscribe(response -> {
				            System.out.println("Response received: " + response);
				        }, error -> {
				            System.err.println("Error: " + error.getMessage());
				        });
		postMonoResponse.block();
	}

	@Override
	public void deleteLand_ManageNavigation_Production(long landID, String username) {
		// POST request
				String fullPostURL = kafkaBaseURL+"/managenaviagation/deleteland";
				LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
				requestJson.add("landID", ""+landID);
				requestJson.add("username", ""+username);
				Mono<UserInfo_AccountDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, UserInfo_AccountDTO.class);
				        
				AtomicBoolean errorOccurred = new AtomicBoolean(false);
				postMonoResponse.doOnError(error -> errorOccurred.set(true))
				        .subscribe(response -> {
				            System.out.println("Response received: " + response);
				        }, error -> {
				            System.err.println("Error: " + error.getMessage());
				        });
				postMonoResponse.block();
	}

	@Override
	public void editLand_ManageNavigation_Production(ManageNavigation_FastCreateLandDTO landDTO, String username) {
		// POST request
		String fullPostURL = kafkaBaseURL+"/managenavigation/createland";
		LinkedMultiValueMap<String, String> requestJson = new LinkedMultiValueMap<String, String>();
		requestJson.add("landID",""+landDTO.getLandID() );
		requestJson.add("landName",landDTO.getLandName() );
		requestJson.add("orderCreationDate", ""+landDTO.getOrderCreationDate());
		requestJson.add("propertyRentalPrice", ""+landDTO.getPropertyRentalPrice());
		requestJson.add("landAddress", landDTO.getLandAddress());
		requestJson.add("landAddressPostcode", landDTO.getLandAddressPostcode());
		requestJson.add("username", ""+username);
		Mono<ManageNavigation_FastCreateLandDTO> postMonoResponse = apiCaller.post(fullPostURL, requestJson, ManageNavigation_FastCreateLandDTO.class);
		        
		AtomicBoolean errorOccurred = new AtomicBoolean(false);
		postMonoResponse.doOnError(error -> errorOccurred.set(true))
		        .subscribe(response -> {
		            System.out.println("Response received: " + response);
		        }, error -> {
		            System.err.println("Error: " + error.getMessage());
		        });
		postMonoResponse.block();
	}
	

}
