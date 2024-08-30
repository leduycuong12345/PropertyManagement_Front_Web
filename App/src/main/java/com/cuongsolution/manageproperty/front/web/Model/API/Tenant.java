package com.cuongsolution.manageproperty.front.web.Model.API;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Tenant {
	private long tenantId;
	private String tenantFirstName;
	private String tenantLastName;
	private String tenantCI;
	private String tenantPhoneNumber;
	private String tenantVerifiedEmail;
	private Date tenantRegisterdDate;
	private String tenantIP;
	@DateTimeFormat(pattern="dd-MM-yyyy",iso = DateTimeFormat.ISO.DATE)//https://www.baeldung.com/spring-date-parameters
	private LocalDate tenant_Birth_Date;

	private List<Contract> contacts = new ArrayList<>();
	
	
	public Tenant() {
		super();
	}
	
	

	public long getTenantId() {
		return tenantId;
	}



	public void setTenantId(long tenantId) {
		this.tenantId = tenantId;
	}



	public String getTenantFirstName() {
		return tenantFirstName;
	}



	public void setTenantFirstName(String tenantFirstName) {
		this.tenantFirstName = tenantFirstName;
	}



	public String getTenantLastName() {
		return tenantLastName;
	}



	public void setTenantLastName(String tenantLastName) {
		this.tenantLastName = tenantLastName;
	}



	public String getTenantCI() {
		return tenantCI;
	}



	public void setTenantCI(String tenantCI) {
		this.tenantCI = tenantCI;
	}



	public String getTenantPhoneNumber() {
		return tenantPhoneNumber;
	}



	public void setTenantPhoneNumber(String tenantPhoneNumber) {
		this.tenantPhoneNumber = tenantPhoneNumber;
	}



	public String getTenantVerifiedEmail() {
		return tenantVerifiedEmail;
	}



	public void setTenantVerifiedEmail(String tenantVerifiedEmail) {
		this.tenantVerifiedEmail = tenantVerifiedEmail;
	}



	public Date getTenantRegisterdDate() {
		return tenantRegisterdDate;
	}



	public void setTenantRegisterdDate(Date tenantRegisterdDate) {
		this.tenantRegisterdDate = tenantRegisterdDate;
	}



	public String getTenantIP() {
		return tenantIP;
	}



	public void setTenantIP(String tenantIP) {
		this.tenantIP = tenantIP;
	}



	public List<Contract> getContacts() {
		return contacts;
	}



	public void setContacts(List<Contract> contacts) {
		this.contacts = contacts;
	}


	public LocalDate getTenant_Birth_Date() {
		return tenant_Birth_Date;
	}



	public void setTenant_Birth_Date(LocalDate tenant_Birth_Date) {
		this.tenant_Birth_Date = tenant_Birth_Date;
	}



	public Tenant(String tenantLastName, String tenantCI, String tenantPhoneNumber, LocalDate tenant_Birth_Date) {
		super();
		this.tenantLastName = tenantLastName;
		this.tenantCI = tenantCI;
		this.tenantPhoneNumber = tenantPhoneNumber;
		this.tenant_Birth_Date = tenant_Birth_Date;
	}
}
