package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageProperty_FastCreateOrderList_RecurringExpanseDTO {
	private long propertyServiceID;
	private int expanseType;
	private float previousReadingValue;
	private float currentReadingValue;
	
	public long getPropertyServiceID() {
		return propertyServiceID;
	}
	public void setPropertyServiceID(long propertyServiceID) {
		this.propertyServiceID = propertyServiceID;
	}
	public int getExpanseType() {
		return expanseType;
	}
	public void setExpanseType(int expanseType) {
		this.expanseType = expanseType;
	}
	public float getPreviousReadingValue() {
		return previousReadingValue;
	}
	public float getCurrentReadingValue() {
		return currentReadingValue;
	}
	public void setCurrentReadingValue(float currentReadingValue) {
		this.currentReadingValue = currentReadingValue;
	}
	public void setPreviousReadingValue(float previousReadingValue) {
		this.previousReadingValue = previousReadingValue;
	}
	
	
	
}
