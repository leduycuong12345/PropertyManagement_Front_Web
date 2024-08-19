package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ManageTenant_EditTenant_TenantDTO {
	private Long tenantID;
	private String tenantName;
	private String tenantPhoneNumber;
	private String tenantCI;
	@DateTimeFormat(pattern ="yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE_TIME)//https://www.baeldung.com/spring-date-parameters
	private LocalDate tenantBirthDate;
	private Long contractID;
	
	public ManageTenant_EditTenant_TenantDTO(Long tenantID, String tenantName, String tenantPhoneNumber, String tenantCI,
			LocalDate tenantBirthDate, Long contractID) {
		super();
		this.tenantID = tenantID;
		this.tenantName = tenantName;
		this.tenantPhoneNumber = tenantPhoneNumber;
		this.tenantCI = tenantCI;
		this.tenantBirthDate = tenantBirthDate;
		this.contractID = contractID;
	}
	public Long getTenantID() {
		return tenantID;
	}
	public Long getContractID() {
		return contractID;
	}
	public void setContractID(Long contractID) {
		this.contractID = contractID;
	}
	public void setTenantID(Long tenantID) {
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
	public ManageTenant_EditTenant_TenantDTO() {
		super();
	}
	
	
}
