package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class ManageProperty_EditFastRecurringExpanseListDTO {
	private UUID propertyID;
	private List<String> editExpanseList=new ArrayList<String>();
	public UUID getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(UUID propertyID) {
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
	public ManageProperty_EditFastRecurringExpanseListDTO(UUID propertyID, List<String> editExpanseList) {
		super();
		this.propertyID = propertyID;
		this.editExpanseList = editExpanseList;
	}
}
