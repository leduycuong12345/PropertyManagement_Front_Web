package com.cuongsolution.manageproperty.front.web.Service.Chart;

import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_DepositChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_EconomicHealthyChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_ExpanseChart;
import com.cuongsolution.manageproperty.front.web.DTO.ManageCharts_PropertyRateChart;

public interface ManageCharts_ChartService {
	public abstract ManageCharts_PropertyRateChart getPropertyRateChart_ManageCharts(long landId);
	public abstract ManageCharts_EconomicHealthyChart getEconomicHealthyChart_ManageCharts(long landId) ;
	public abstract ManageCharts_DepositChart getDepositChart_ManageCharts(long landId);
	public abstract ManageCharts_ExpanseChart getExpanseChart_ManageCharts(long landId);
}
