package com.cuongsolution.manageproperty.front.web.DTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


public class ManageWorksheet_WorksheetDTO {
	private long worksheetID;
	//private PropertyDTO property;
	private double currentPropertyRentalPrice;
	private double depositAmount;
	private int timeInterval;
	private String propertyName;//readonly no-edit.
	private int tenantTotal;
	private String delegateTenantName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Asia/Bangkok")
	private Date worksheetCreateDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Asia/Bangkok")
	private Date worksheetExpireDate;
	public ManageWorksheet_WorksheetDTO() {
		super();
	}
	public long getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(long worksheetID) {
		this.worksheetID = worksheetID;
	}
	public double getCurrentPropertyRentalPrice() {
		return currentPropertyRentalPrice;
	}
	public void setCurrentPropertyRentalPrice(double currentPropertyRentalPrice) {
		this.currentPropertyRentalPrice = currentPropertyRentalPrice;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public int getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public int getTenantTotal() {
		return tenantTotal;
	}
	public void setTenantTotal(int tenantTotal) {
		this.tenantTotal = tenantTotal;
	}
	public Date getWorksheetCreateDate() {
		return worksheetCreateDate;
	}
	public void setWorksheetCreateDate(Date worksheetCreateDate) {
		this.worksheetCreateDate = worksheetCreateDate;
	}
	public Date getWorksheetExpireDate() {
		return worksheetExpireDate;
	}
	public void setWorksheetExpireDate(Date worksheetExpireDate) {
		this.worksheetExpireDate = worksheetExpireDate;
	}
	public String getDelegateTenantName() {
		return delegateTenantName;
	}
	public void setDelegateTenantName(String delegateTenantName) {
		this.delegateTenantName = delegateTenantName;
	}
	public ManageWorksheet_WorksheetDTO(long worksheetID, double currentPropertyRentalPrice, double depositAmount,
			int timeInterval, String propertyName, int tenantTotal, String delegateTenantName, Date worksheetCreateDate,
			Date worksheetExpireDate) {
		super();
		this.worksheetID = worksheetID;
		this.currentPropertyRentalPrice = currentPropertyRentalPrice;
		this.depositAmount = depositAmount;
		this.timeInterval = timeInterval;
		this.propertyName = propertyName;
		this.tenantTotal = tenantTotal;
		this.delegateTenantName = delegateTenantName;
		this.worksheetCreateDate = worksheetCreateDate;
		this.worksheetExpireDate = worksheetExpireDate;
	}
	
	
	
}
