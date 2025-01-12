package com.cuongsolution.manageproperty.front.web.Service.Chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;

import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_DepositChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_EconomicHealthyChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_ExpanseChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_PropertyRateChart;
import com.cuongsolution.manageproperty.front.web.Service.Utils.RequestAPI_Service;

import reactor.core.publisher.Mono;

@Service
public class ManageCharts_ChartServiceImpl implements ManageCharts_ChartService {
	@Value("${cuongsolution.manageproperty.core.kafka.baseURL}")//this variable being declared at application.properties
	private String kafkaBaseURL;
	@Autowired
	private RequestAPI_Service apiCaller;

	@Override
	public ManageCharts_PropertyRateChart getPropertyRateChart_ManageCharts(long landId) {
		String fullPostURL = kafkaBaseURL+"/manageexpanse/land/findlandbyid";
		LinkedMultiValueMap<String, String> requestJson = 
				new LinkedMultiValueMap<String, String>();
		requestJson.add("LandID", ""+landId);
        Mono<ManageCharts_PropertyRateChart> postMonoResponse = apiCaller.post(fullPostURL, requestJson, ManageCharts_PropertyRateChart.class);
        
        return postMonoResponse.block();
	}

	@Override
	public ManageCharts_EconomicHealthyChart getEconomicHealthyChart_ManageCharts(long landId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManageCharts_DepositChart getDepositChart_ManageCharts(long landId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManageCharts_ExpanseChart getExpanseChart_ManageCharts(long landId) {
		// TODO Auto-generated method stub
		return null;
	}

}
