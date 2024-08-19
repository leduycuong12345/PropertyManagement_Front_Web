package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;



public class ManageProperty_EditFastRecurringExpanseListDTO {
	private long propertyID;
	private List<String> editExpanseList=new ArrayList<String>();
	public long getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}
	public ManageProperty_EditFastRecurringExpanseListDTO() {
		super();
	}
	public List<String> getEditExpanseList() {
		return editExpanseList;
	}
	public void setEditExpanseList(List<String> editExpanseList) {
		this.editExpanseList = editExpanseList;
	}
	public ManageProperty_EditFastRecurringExpanseListDTO(long propertyID, List<String> editExpanseList) {
		super();
		this.propertyID = propertyID;
		this.editExpanseList = editExpanseList;
	}
}
