package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageProperty_CreateOrder_RecurringExpanseDTO {
	private UUID propertyServiceID;
	private int expanseType;
	private Double previousReadingValue;
	private Double currentReadingValue;
	
	public ManageProperty_CreateOrder_RecurringExpanseDTO() {
		super();
	}
	public UUID getPropertyServiceID() {
		return propertyServiceID;
	}
	public void setPropertyServiceID(UUID propertyServiceID) {
		this.propertyServiceID = propertyServiceID;
	}
	public int getExpanseType() {
		return expanseType;
	}
	public void setExpanseType(int expanseType) {
		this.expanseType = expanseType;
	}
	public Double getPreviousReadingValue() {
		return previousReadingValue;
	}
	public Double getCurrentReadingValue() {
		return currentReadingValue;
	}
	public void setCurrentReadingValue(Double currentReadingValue) {
		this.currentReadingValue = currentReadingValue;
	}
	public void setPreviousReadingValue(Double previousReadingValue) {
		this.previousReadingValue = previousReadingValue;
	}
	public ManageProperty_CreateOrder_RecurringExpanseDTO(UUID propertyServiceID, int expanseType,
			Double previousReadingValue, Double currentReadingValue) {
		super();
		this.propertyServiceID = propertyServiceID;
		this.expanseType = expanseType;
		this.previousReadingValue = previousReadingValue;
		this.currentReadingValue = currentReadingValue;
	}
	
	
	
}

