package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;


public class ManageProperty_AddTenantToWorksheetDTO {
	private long worksheetID;
	private String tenantName;
	private String tenantPhoneNumber;
	private String tenantCI;
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
	private LocalDate tenantBirthDate;
	public LocalDate getTenantBirthDate() {
		return tenantBirthDate;
	}
	public void setTenantBirthDate(LocalDate tenantBirthDate) {
		this.tenantBirthDate = tenantBirthDate;
	}
	public ManageProperty_AddTenantToWorksheetDTO() {
		super();
	}
	public long getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(long worksheetID) {
		this.worksheetID = worksheetID;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getTenantPhoneNumber() {
		return tenantPhoneNumber;
	}
	public void setTenantPhoneNumber(String tenantPhoneNumber) {
		this.tenantPhoneNumber = tenantPhoneNumber;
	}
	public String getTenantCI() {
		return tenantCI;
	}
	public void setTenantCI(String tenantCI) {
		this.tenantCI = tenantCI;
	}
	public ManageProperty_AddTenantToWorksheetDTO(long worksheetID,
			String tenantName, String tenantPhoneNumber,
			String tenantCI, LocalDate tenantBirthDate) {
		super();
		this.worksheetID = worksheetID;
		this.tenantName = tenantName;
		this.tenantPhoneNumber = tenantPhoneNumber;
		this.tenantCI = tenantCI;
		this.tenantBirthDate = tenantBirthDate;
	}
	
	
	
	
	
}
