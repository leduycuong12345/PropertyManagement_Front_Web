package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ManageProperty_DepositDTO {
	private long worksheetID;
	private double depositAmount;
	@DateTimeFormat(pattern = "yyyy-MM")
	private Date orderBelongMonth;
	public long getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(long worksheetID) {
		this.worksheetID = worksheetID;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Date getOrderBelongMonth() {
		return orderBelongMonth;
	}
	public void setOrderBelongMonth(Date orderBelongMonth) {
		this.orderBelongMonth = orderBelongMonth;
	}
	
}
