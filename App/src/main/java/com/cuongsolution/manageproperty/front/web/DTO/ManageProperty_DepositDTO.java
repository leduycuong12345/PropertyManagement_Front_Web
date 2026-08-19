package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class ManageProperty_DepositDTO {
	private UUID worksheetID;
	private double depositAmount;
	@DateTimeFormat(pattern = "yyyy-MM")
	private String orderBelongMonth;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate parsedOrderBelongMonth ;
	public UUID getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(UUID worksheetID) {
		this.worksheetID = worksheetID;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public String getOrderBelongMonth() {
		return orderBelongMonth;
	}
	public void setOrderBelongMonth(String orderBelongMonth) {
		this.orderBelongMonth = orderBelongMonth;
	}
	public LocalDate getParsedOrderBelongMonth() {
		return parsedOrderBelongMonth;
	}
	public void setParsedOrderBelongMonth(String orderBelongMonth) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.parsedOrderBelongMonth= LocalDate.parse(orderBelongMonth+"-01", formatter);
	}
	
}
