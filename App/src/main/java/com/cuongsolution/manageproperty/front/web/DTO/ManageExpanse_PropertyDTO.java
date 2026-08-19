package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageExpanse_PropertyDTO {
	private UUID propertyID;
	private String propertyName;
	
	public UUID getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(UUID propertyID) {
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
	public ManageExpanse_PropertyDTO(UUID propertyID, String propertyName) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
	}
	
	
}
