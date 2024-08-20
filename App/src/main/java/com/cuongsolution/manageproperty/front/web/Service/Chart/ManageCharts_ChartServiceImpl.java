package com.cuongsolution.manageproperty.front.web.Service.Chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_DepositChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_EconomicHealthyChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_ExpanseChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_PropertyRateChart;

@Service
public class ManageCharts_ChartServiceImpl implements ManageCharts_ChartService {
	

	@Override
	public ManageCharts_PropertyRateChart getPropertyRateChart_ManageCharts(long landId) {
		return null;
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
