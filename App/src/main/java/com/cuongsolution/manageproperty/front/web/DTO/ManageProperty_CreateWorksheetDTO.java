package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class ManageProperty_CreateWorksheetDTO {
	private long propertyID;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate worksheetCreateDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate worksheetEndDate;
	private String firstTenantName;
	private String firstTenantPhoneNumber;
	private String firstTenantCI;
	private double depositAmount;
	private double worksheetRentalPrice;
	private int timeInterval;
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
	private LocalDate firstTenantBirthDate;
	private List<String> selectedExpanseList=new ArrayList<String>();//at the client-side , form post ll send a string that content object[id:long,value:float] as "object.id,object.value"
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
	
	
	
	public LocalDate getFirstTenantBirthDate() {
		return firstTenantBirthDate;
	}
	public void setFirstTenantBirthDate(LocalDate firstTenantBirthDate) {
		this.firstTenantBirthDate = firstTenantBirthDate;
	}
	public List<String> getSelectedExpanseList() {
		return selectedExpanseList;
	}
	public void setSelectedExpanseList(List<String> selectedExpanseList) {
		this.selectedExpanseList = selectedExpanseList;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public double getWorksheetRentalPrice() {
		return worksheetRentalPrice;
	}
	public void setWorksheetRentalPrice(double worksheetRentalPrice) {
		this.worksheetRentalPrice = worksheetRentalPrice;
	}
	public ManageProperty_CreateWorksheetDTO() {
		super();
	}
	
	public int getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	public ManageProperty_CreateWorksheetDTO(long propertyID, LocalDate worksheetCreateDate,
			LocalDate worksheetEndDate,
			String firstTenantName, String firstTenantPhoneNumber,
			String firstTenantCI, LocalDate tenantBirthDate,
			List<String> selectedExpanseList) {
		super();
		this.propertyID = propertyID;
		this.worksheetCreateDate = worksheetCreateDate;
		this.worksheetEndDate = worksheetEndDate;
		this.firstTenantName = firstTenantName;
		this.firstTenantPhoneNumber = firstTenantPhoneNumber;
		this.firstTenantCI = firstTenantCI;
		this.firstTenantBirthDate = tenantBirthDate;
		this.selectedExpanseList = selectedExpanseList;
	}
	
	
}
