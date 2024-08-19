package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;

public class ManageProperty_FastCreateOrderList_WorksheetDTO {
	private long worksheetID;
	private double totalCost;
	private List<ManageProperty_FastCreateOrderList_RecurringExpanseDTO> expanseList=new ArrayList<ManageProperty_FastCreateOrderList_RecurringExpanseDTO>();
	public long getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(long worksheetID) {
		this.worksheetID = worksheetID;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public List<ManageProperty_FastCreateOrderList_RecurringExpanseDTO> getExpanseList() {
		return expanseList;
	}
	public void setExpanseList(List<ManageProperty_FastCreateOrderList_RecurringExpanseDTO> expanseList) {
		this.expanseList = expanseList;
	}
	
}
