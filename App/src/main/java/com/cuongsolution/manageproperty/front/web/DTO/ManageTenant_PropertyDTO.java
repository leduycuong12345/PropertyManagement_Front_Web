package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;

public class ManageTenant_PropertyDTO {
	private Long propertyID;
	private String propertyName;
	private List<ManageTenant_TenantDTO> tenantList=
			new ArrayList<ManageTenant_TenantDTO>();
	public Long getPropertyID() {
		return propertyID;
	}
	public ManageTenant_PropertyDTO(Long propertyID, String propertyName) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
	}
	public void setPropertyID(Long propertyID) {
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
