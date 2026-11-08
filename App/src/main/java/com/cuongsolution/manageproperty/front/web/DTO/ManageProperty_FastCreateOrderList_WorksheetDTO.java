package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManageProperty_FastCreateOrderList_WorksheetDTO {
	private UUID worksheetID;
	private double totalCost;
	private List<ManageProperty_FastCreateOrderList_RecurringExpanseDTO> expanseList=new ArrayList<ManageProperty_FastCreateOrderList_RecurringExpanseDTO>();
	private Boolean expanseType=true;// Cong-them hoac /tru-vao
	private Double expanseCost=(double)0;
	private String expanseDetails="";
	
	
	public Boolean getExpanseType() {
		return expanseType;
	}
	public void setExpanseType(Boolean expanseType) {
		this.expanseType = expanseType;
	}
	public Double getExpanseCost() {
		return expanseCost;
	}
	public void setExpanseCost(Double expanseCost) {
		this.expanseCost = expanseCost;
	}
	public String getExpanseDetails() {
		return expanseDetails;
	}
	public void setExpanseDetails(String expanseDetails) {
		this.expanseDetails = expanseDetails;
	}
	public UUID getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(UUID worksheetID) {
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
