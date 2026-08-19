package com.cuongsolution.manageproperty.front.web.Service.Chart;

import java.util.UUID;

import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_DepositChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_EconomicHealthyChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_ExpanseChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_PropertyRateChart;

public interface ManageCharts_ChartService {
	public abstract ManageCharts_PropertyRateChart getPropertyRateChart_ManageCharts(UUID landId);
	public abstract ManageCharts_EconomicHealthyChart getEconomicHealthyChart_ManageCharts(UUID landId) ;
	public abstract ManageCharts_DepositChart getDepositChart_ManageCharts(UUID landId);
	public abstract ManageCharts_ExpanseChart getExpanseChart_ManageCharts(UUID landId);
}
