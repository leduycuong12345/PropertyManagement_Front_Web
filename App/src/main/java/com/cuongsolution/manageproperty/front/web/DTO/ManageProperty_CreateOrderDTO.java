package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class ManageProperty_CreateOrderDTO {
	private long worksheetID;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderCreateDate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderExpireDate;
	@DateTimeFormat(pattern = "yyyy-MM")
	private Date orderBelongMonth;
	private int totalMonth;
	private int totalDay;
	private double totalCost;
	private List<String> recurringExpanseList_withCurrentReading=new ArrayList<String>();//at the client-side , form post ll send a string that content object[id:long,value:float] as "object.id,object.value"
	private boolean expanseType;// Cong-them hoac /tru-vao
	private double expanseCost;
	private String expanseDetails;
	public long getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(long worksheetID) {
		this.worksheetID = worksheetID;
	}
	
	public int getTotalMonth() {
		return totalMonth;
	}
	public void setTotalMonth(int totalMonth) {
		this.totalMonth = totalMonth;
	}
	public int getTotalDay() {
		return totalDay;
	}
	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}
	
	public LocalDate getOrderCreateDate() {
		return orderCreateDate;
	}
	public void setOrderCreateDate(LocalDate orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}
	public LocalDate getOrderExpireDate() {
		return orderExpireDate;
	}
	public void setOrderExpireDate(LocalDate orderExpireDate) {
		this.orderExpireDate = orderExpireDate;
	}
	
	public Date getOrderBelongMonth() {
		return orderBelongMonth;
	}
	public void setOrderBelongMonth(Date orderBelongMonth) {
		this.orderBelongMonth = orderBelongMonth;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public List<String> getRecurringExpanseList_withCurrentReading() {
		return recurringExpanseList_withCurrentReading;
	}
	public void setRecurringExpanseList_withCurrentReading(List<String> recurringExpanseList_withCurrentReading) {
		this.recurringExpanseList_withCurrentReading = recurringExpanseList_withCurrentReading;
	}
	public boolean isExpanseType() {
		return expanseType;
	}
	public void setExpanseType(boolean expanseType) {
		this.expanseType = expanseType;
	}
	public double getExpanseCost() {
		return expanseCost;
	}
	public void setExpanseCost(double expanseCost) {
		this.expanseCost = expanseCost;
	}
	public String getExpanseDetails() {
		return expanseDetails;
	}
	public void setExpanseDetails(String expanseDetails) {
		this.expanseDetails = expanseDetails;
	}
	public ManageProperty_CreateOrderDTO() {
		super();
	}
	
	
	
	
}
