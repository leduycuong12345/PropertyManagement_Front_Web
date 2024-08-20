package com.cuongsolution.manageproperty.front.web.Model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


public class Receipt {
	private long ReceiptId;
	private double receipt_Amount;
	private String receipt_Note;
	private int receipt_Type;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate receipt_Date;
	private boolean receipt_Is_Delete=false;
	
	private OrderInfo orderInfo;


	public long getReceiptId() {
		return ReceiptId;
	}


	public void setReceiptId(long receiptId) {
		ReceiptId = receiptId;
	}


	public double getReceipt_Amount() {
		return receipt_Amount;
	}


	public void setReceipt_Amount(double receipt_Amount) {
		this.receipt_Amount = receipt_Amount;
	}


	public String getReceipt_Note() {
		return receipt_Note;
	}


	public void setReceipt_Note(String receipt_Note) {
		this.receipt_Note = receipt_Note;
	}


	public int getReceipt_Type() {
		return receipt_Type;
	}


	public void setReceipt_Type(int receipt_Type) {
		this.receipt_Type = receipt_Type;
	}


	public LocalDate getReceipt_Date() {
		return receipt_Date;
	}


	public void setReceipt_Date(LocalDate receipt_Date) {
		this.receipt_Date = receipt_Date;
	}


	public boolean isReceipt_Is_Delete() {
		return receipt_Is_Delete;
	}


	public void setReceipt_Is_Delete(boolean receipt_Is_Delete) {
		this.receipt_Is_Delete = receipt_Is_Delete;
	}


	public OrderInfo getOrderInfo() {
		return orderInfo;
	}


	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}


	public Receipt(double receipt_Amount, String receipt_Note, int receipt_Type, LocalDate receipt_Date,
			OrderInfo orderInfo) {
		super();
		this.receipt_Amount = receipt_Amount;
		this.receipt_Note = receipt_Note;
		this.receipt_Type = receipt_Type;
		this.receipt_Date = receipt_Date;
		this.orderInfo = orderInfo;
	}
	
	
	
}
