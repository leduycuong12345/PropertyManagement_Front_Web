package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ManageOrder_ReceiptDTO {
	private Long orderID;
	private double receiptAmount;
	private String receiptNote;
	private int receiptType;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate receiptDate;
	public Long getOrderID() {
		return orderID;
	}
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	
	public String getReceiptNote() {
		return receiptNote;
	}
	public void setReceiptNote(String receiptNote) {
		this.receiptNote = receiptNote;
	}
	public int getReceiptType() {
		return receiptType;
	}
	public void setReceiptType(int receiptType) {
		this.receiptType = receiptType;
	}
	public LocalDate getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(LocalDate receiptDate) {
		this.receiptDate = receiptDate;
	}
	
	
	public double getReceiptAmount() {
		return receiptAmount;
	}
	public void setReceiptAmount(double receiptAmount) {
		this.receiptAmount = receiptAmount;
	}
	public ManageOrder_ReceiptDTO() {
		super();
	}
	
}
