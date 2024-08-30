package com.cuongsolution.manageproperty.front.web.Model.API;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonBackReference;


public class Worksheet {
	private long worksheet_ID;
	private double deposit_Amount;
	private int	time_Interval=0;
	private double debt_Amount;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date worksheet_Create_Date;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date worksheet_Expire_Date;
	private int worksheet_Order_Create_Date;
	private double current_Property_Rental_Price;
	private boolean worksheet_Is_Delete=false;
	private double deposit_Remaining_Amount;
	private boolean is_Booked=false;
	@OneToMany(
	        mappedBy = "worksheet",
	        cascade = CascadeType.ALL
	    )
	@JsonBackReference
	private List<Contract> contracts = new ArrayList<>();
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Property_Property_ID" , nullable = false)//Property_Property_ID named attribute store in db.
	private Property property;
	
	@OneToMany(
	        mappedBy = "worksheet",
	        cascade = CascadeType.ALL
	    )
	@JsonBackReference
	private List<OrderInfo> orderInfoList = new ArrayList<>();
	
	
	public boolean isIs_Booked() {
		return is_Booked;
	}
	public void setIs_Booked(boolean is_Booked) {
		this.is_Booked = is_Booked;
	}
	public double getDebt_Amount() {
		return debt_Amount;
	}
	public void setDebt_Amount(double debt_Amount) {
		this.debt_Amount = debt_Amount;
	}
	public int getWorksheet_Order_Create_Date() {
		return worksheet_Order_Create_Date;
	}
	public void setWorksheet_Order_Create_Date(int worksheet_Order_Create_Date) {
		this.worksheet_Order_Create_Date = worksheet_Order_Create_Date;
	}
	public List<OrderInfo> getOrderInfoList() {
		return orderInfoList;
	}
	public void setOrderInfoList(List<OrderInfo> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public long getWorksheet_ID() {
		return worksheet_ID;
	}
	public void setWorksheet_ID(long worksheet_ID) {
		this.worksheet_ID = worksheet_ID;
	}
	
	public double getDeposit_Amount() {
		return deposit_Amount;
	}
	public void setDeposit_Amount(double deposit_Amount) {
		this.deposit_Amount = deposit_Amount;
	}
	public int getTime_Interval() {
		return time_Interval;
	}
	public void setTime_Interval(int time_Interval) {
		this.time_Interval = time_Interval;
	}
	public double getCurrent_Property_Rental_Price() {
		return current_Property_Rental_Price;
	}
	public void setCurrent_Property_Rental_Price(double current_Property_Rental_Price) {
		this.current_Property_Rental_Price = current_Property_Rental_Price;
	}
	
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	public Worksheet() {
		super();
	}
	public boolean isWorksheet_Is_Delete() {
		return worksheet_Is_Delete;
	}
	public void setWorksheet_Is_Delete(boolean worksheet_Is_Delete) {
		this.worksheet_Is_Delete = worksheet_Is_Delete;
	}
	public Worksheet(long worksheet_ID) {
		super();
		this.worksheet_ID = worksheet_ID;
	}
	public Date getWorksheet_Create_Date() {
		return worksheet_Create_Date;
	}
	public void setWorksheet_Create_Date(Date worksheet_Create_Date) {
		this.worksheet_Create_Date = worksheet_Create_Date;
	}
	public Date getWorksheet_Expire_Date() {
		return worksheet_Expire_Date;
	}
	public void setWorksheet_Expire_Date(Date worksheet_Expire_Date) {
		this.worksheet_Expire_Date = worksheet_Expire_Date;
	}
	public double getDeposit_Remaining_Amount() {
		return deposit_Remaining_Amount;
	}
	public void setDeposit_Remaining_Amount(double deposit_Remaining_Amount) {
		this.deposit_Remaining_Amount = deposit_Remaining_Amount;
	}
	
}
