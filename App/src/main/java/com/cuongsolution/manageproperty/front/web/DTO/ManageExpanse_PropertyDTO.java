package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageExpanse_PropertyDTO {
	private long propertyID;
	private String propertyName;
	
	public long getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public ManageExpanse_PropertyDTO() {
		super();
	}
	public ManageExpanse_PropertyDTO(long propertyID, String propertyName) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
	}
	
	
}
