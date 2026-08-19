package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageExpanse_PropertyServiceDTO {
	private UUID propertyServiceID;
	private String propertyName;
	private boolean propertyServiceIsDelete;
	public ManageExpanse_PropertyServiceDTO(UUID propertyServiceID, String propertyName,
			boolean propertyServiceIsDelete) {
		super();
		this.propertyServiceID = propertyServiceID;
		this.propertyName = propertyName;
		this.propertyServiceIsDelete = propertyServiceIsDelete;
	}
	public UUID getPropertyServiceID() {
		return propertyServiceID;
	}
	public void setPropertyServiceID(UUID propertyServiceID) {
		this.propertyServiceID = propertyServiceID;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public boolean isPropertyServiceIsDelete() {
		return propertyServiceIsDelete;
	}
	public void setPropertyServiceIsDelete(boolean propertyServiceIsDelete) {
		this.propertyServiceIsDelete = propertyServiceIsDelete;
	}
	public ManageExpanse_PropertyServiceDTO() {
		super();
	}
	
}
