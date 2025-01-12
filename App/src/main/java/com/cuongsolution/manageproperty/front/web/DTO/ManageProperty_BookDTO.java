package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class ManageProperty_BookDTO {
	private long propertyID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate worksheetCreateDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate worksheetEndDate;
	private String firstTenantName;
	private String firstTenantPhoneNumber;
	private String firstTenantCI;
	private double prepaidAmount;
	private double worksheetRentalPrice;
	private int timeInterval;
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
	private LocalDate firstTenantBirthDate;
	
	public int getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	public long getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}
	public LocalDate getWorksheetCreateDate() {
		return worksheetCreateDate;
	}
	public void setWorksheetCreateDate(LocalDate worksheetCreateDate) {
		this.worksheetCreateDate = worksheetCreateDate;
	}
	public LocalDate getWorksheetEndDate() {
		return worksheetEndDate;
	}
	public void setWorksheetEndDate(LocalDate worksheetEndDate) {
		this.worksheetEndDate = worksheetEndDate;
	}
	public String getFirstTenantName() {
		return firstTenantName;
	}
	public void setFirstTenantName(String firstTenantName) {
		this.firstTenantName = firstTenantName;
	}
	public String getFirstTenantPhoneNumber() {
		return firstTenantPhoneNumber;
	}
	public void setFirstTenantPhoneNumber(String firstTenantPhoneNumber) {
		this.firstTenantPhoneNumber = firstTenantPhoneNumber;
	}
	public String getFirstTenantCI() {
		return firstTenantCI;
	}
	public void setFirstTenantCI(String firstTenantCI) {
		this.firstTenantCI = firstTenantCI;
	}
	
	
	
	public double getPrepaidAmount() {
		return prepaidAmount;
	}
	public void setPrepaidAmount(double prepaidAmount) {
		this.prepaidAmount = prepaidAmount;
	}
	public LocalDate getFirstTenantBirthDate() {
		return firstTenantBirthDate;
	}
	public void setFirstTenantBirthDate(LocalDate firstTenantBirthDate) {
		this.firstTenantBirthDate = firstTenantBirthDate;
	}
	
	public double getWorksheetRentalPrice() {
		return worksheetRentalPrice;
	}
	public void setWorksheetRentalPrice(double worksheetRentalPrice) {
		this.worksheetRentalPrice = worksheetRentalPrice;
	}
	public ManageProperty_BookDTO() {
		super();
	}
	
	public ManageProperty_BookDTO(long propertyID, LocalDate worksheetCreateDate, LocalDate worksheetEndDate,
			String firstTenantName, String firstTenantPhoneNumber, String firstTenantCI, LocalDate tenantBirthDate) {
		super();
		this.propertyID = propertyID;
		this.worksheetCreateDate = worksheetCreateDate;
		this.worksheetEndDate = worksheetEndDate;
		this.firstTenantName = firstTenantName;
		this.firstTenantPhoneNumber = firstTenantPhoneNumber;
		this.firstTenantCI = firstTenantCI;
		this.firstTenantBirthDate = tenantBirthDate;
	}
	
	
}
