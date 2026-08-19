package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class ManageTenant_TenantDTO {
	private UUID tenantID;
	private String tenantName;
	private String tenantPhoneNumber;
	private String tenantCI;
	@DateTimeFormat(pattern = "dd-MM-yyyy",iso = DateTimeFormat.ISO.DATE)
	private LocalDate tenantBirthDate;
	private UUID contractID;
	
	public ManageTenant_TenantDTO(UUID tenantID, String tenantName, String tenantPhoneNumber, String tenantCI,
			LocalDate tenantBirthDate, UUID contractID) {
		super();
		this.tenantID = tenantID;
		this.tenantName = tenantName;
		this.tenantPhoneNumber = tenantPhoneNumber;
		this.tenantCI = tenantCI;
		this.tenantBirthDate = tenantBirthDate;
		this.contractID = contractID;
	}
	public UUID getTenantID() {
		return tenantID;
	}
	public UUID getContractID() {
		return contractID;
	}
	public void setContractID(UUID contractID) {
		this.contractID = contractID;
	}
	public void setTenantID(UUID tenantID) {
		this.tenantID = tenantID;
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
	public LocalDate getTenantBirthDate() {
		return tenantBirthDate;
	}
	public void setTenantBirthDate(LocalDate tenantBirthDate) {
		this.tenantBirthDate = tenantBirthDate;
	}
	public ManageTenant_TenantDTO() {
		super();
	}
	
	
}
