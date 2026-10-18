package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageProperty_FastCreateOrderList_RecurringExpanseDTO {
	private UUID propertyServiceID;
	private int expanseType;
	private double previousReadingValue;
	private double currentReadingValue;
	
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
	public double getPreviousReadingValue() {
		return previousReadingValue;
	}
	public double getCurrentReadingValue() {
		return currentReadingValue;
	}
	public void setCurrentReadingValue(double currentReadingValue) {
		this.currentReadingValue = currentReadingValue;
	}
	public void setPreviousReadingValue(double previousReadingValue) {
		this.previousReadingValue = previousReadingValue;
	}
	
	
	
}
