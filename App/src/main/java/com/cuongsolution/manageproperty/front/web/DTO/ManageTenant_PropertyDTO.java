package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManageTenant_PropertyDTO {
	private UUID propertyID;
	private String propertyName;
	private List<ManageTenant_TenantDTO> tenantList=
			new ArrayList<ManageTenant_TenantDTO>();
	public UUID getPropertyID() {
		return propertyID;
	}
	public ManageTenant_PropertyDTO(UUID propertyID, String propertyName) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
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
	public List<ManageTenant_TenantDTO> getTenantList() {
		return tenantList;
	}
	public void setTenantList(List<ManageTenant_TenantDTO> tenantList) {
		this.tenantList = tenantList;
	}
	public ManageTenant_PropertyDTO() {
		super();
	}
	
}
