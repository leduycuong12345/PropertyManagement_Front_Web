package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageExpanse_RecurringExpanseUnitDTO {
	private UUID recurringExpanseUnitID;
	private String recurringExpanseUnitName;
	public UUID getRecurringExpanseUnitID() {
		return recurringExpanseUnitID;
	}
	public void setRecurringExpanseUnitID(UUID recurringExpanseUnitID) {
		this.recurringExpanseUnitID = recurringExpanseUnitID;
	}
	public String getRecurringExpanseUnitName() {
		return recurringExpanseUnitName;
	}
	public void setRecurringExpanseUnitName(String recurringExpanseUnitName) {
		this.recurringExpanseUnitName = recurringExpanseUnitName;
	}
	public ManageExpanse_RecurringExpanseUnitDTO(UUID recurringExpanseUnitID, String recurringExpanseUnitName) {
		super();
		this.recurringExpanseUnitID = recurringExpanseUnitID;
		this.recurringExpanseUnitName = recurringExpanseUnitName;
	}
	public ManageExpanse_RecurringExpanseUnitDTO() {
		super();
	}
	
}
