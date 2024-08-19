package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageExpanse_PropertyServiceDTO {
	private long propertyServiceID;
	private String propertyName;
	private boolean propertyServiceIsDelete;
	public ManageExpanse_PropertyServiceDTO(long propertyServiceID, String propertyName,
			boolean propertyServiceIsDelete) {
		super();
		this.propertyServiceID = propertyServiceID;
		this.propertyName = propertyName;
		this.propertyServiceIsDelete = propertyServiceIsDelete;
	}
	public long getPropertyServiceID() {
		return propertyServiceID;
	}
	public void setPropertyServiceID(long propertyServiceID) {
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
