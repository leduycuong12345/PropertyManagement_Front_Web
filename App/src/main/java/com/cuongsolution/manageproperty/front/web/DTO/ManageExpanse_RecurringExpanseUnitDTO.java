package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageExpanse_RecurringExpanseUnitDTO {
	private long recurringExpanseUnitID;
	private String recurringExpanseUnitName;
	public long getRecurringExpanseUnitID() {
		return recurringExpanseUnitID;
	}
	public void setRecurringExpanseUnitID(long recurringExpanseUnitID) {
		this.recurringExpanseUnitID = recurringExpanseUnitID;
	}
	public String getRecurringExpanseUnitName() {
		return recurringExpanseUnitName;
	}
	public void setRecurringExpanseUnitName(String recurringExpanseUnitName) {
		this.recurringExpanseUnitName = recurringExpanseUnitName;
	}
	public ManageExpanse_RecurringExpanseUnitDTO(long recurringExpanseUnitID, String recurringExpanseUnitName) {
		super();
		this.recurringExpanseUnitID = recurringExpanseUnitID;
		this.recurringExpanseUnitName = recurringExpanseUnitName;
	}
	public ManageExpanse_RecurringExpanseUnitDTO() {
		super();
	}
	
}
