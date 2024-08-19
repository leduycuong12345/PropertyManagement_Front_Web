package com.cuongsolution.manageproperty.front.web.DTO;
import java.util.ArrayList;
import java.util.List;

public class ManageCharts_ExpanseChart {
	private List<ManageCharts_DetailsMonthExpanse> expanseList=new ArrayList<>();
	private int type;//1:3 month 2: 6 month 3:12 month
	public List<ManageCharts_DetailsMonthExpanse> getExpanseList() {
		return expanseList;
	}
	public void setExpanseList(List<ManageCharts_DetailsMonthExpanse> expanseList) {
		this.expanseList = expanseList;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
