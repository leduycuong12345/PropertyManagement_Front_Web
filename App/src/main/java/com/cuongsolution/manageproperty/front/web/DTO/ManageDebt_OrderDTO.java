package com.cuongsolution.manageproperty.front.web.DTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class ManageDebt_OrderDTO {
	private long orderID;
	private String propertyName;
	private String deligatedTenantName;
	private String deligatedTenantPhoneNumber;
	private double propertyRentPrice;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderStartChargeDate;
	private double totalAmount;
	private double remainingAmount;
	private double debtAmount;
	private Integer totalMonth;
	private Integer totalDay;
	private List<ManageOrder_ExpanseDTO> expanseList=new ArrayList<ManageOrder_ExpanseDTO>();
	private boolean expanseType;// Cong-them hoac /tru-vao
	private double expanseCost;	
	private String expanseNote;
	private int	orderStatus;//1:chua thanh toan, 2: thanh toan chua het/no 
	private int orderType;//0 hóa đơn tiền cọc,1 hóa đơn thu tiền theo chu kỳ,2 hóa đơn thu tiền kết thúc hợp đồng
	
	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public String getDeligatedTenantPhoneNumber() {
		return deligatedTenantPhoneNumber;
	}

	public void setDeligatedTenantPhoneNumber(String deligatedTenantPhoneNumber) {
		this.deligatedTenantPhoneNumber = deligatedTenantPhoneNumber;
	}

	public String getDeligatedTenantName() {
		return deligatedTenantName;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setDeligatedTenantName(String deligatedTenantName) {
		this.deligatedTenantName = deligatedTenantName;
	}

	public String getExpanseNote() {
		return expanseNote;
	}

	public void setExpanseNote(String expanseNote) {
		this.expanseNote = expanseNote;
	}

	public double getDebtAmount() {
		return debtAmount;
	}

	public void setDebtAmount(double debtAmount) {
		this.debtAmount = debtAmount;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	
	public double getPropertyRentPrice() {
		return propertyRentPrice;
	}

	public void setPropertyRentPrice(double propertyRentPrice) {
		this.propertyRentPrice = propertyRentPrice;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	

	public LocalDate getOrderStartChargeDate() {
		return orderStartChargeDate;
	}

	public void setOrderStartChargeDate(LocalDate orderStartChargeDate) {
		this.orderStartChargeDate = orderStartChargeDate;
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
	
	public Integer getTotalMonth() {
		return totalMonth;
	}
	public void setTotalMonth(Integer totalMonth) {
		this.totalMonth = totalMonth;
	}
	public Integer getTotalDay() {
		return totalDay;
	}
	public void setTotalDay(Integer totalDay) {
		this.totalDay = totalDay;
	}
	public ManageDebt_OrderDTO() {
		super();
	}
	public List<ManageOrder_ExpanseDTO> getExpanseList() {
		return expanseList;
	}
	public void setExpanseList(List<ManageOrder_ExpanseDTO> expanseList) {
		this.expanseList = expanseList;
	}

	public ManageDebt_OrderDTO(long orderID, String propertyName, String deligatedTenantName,
			String deligatedTenantPhoneNumber, double propertyRentPrice,
			LocalDate orderStartChargeDate, double totalAmount, double remainingAmount, double debtAmount,
			Integer totalMonth, Integer totalDay, List<ManageOrder_ExpanseDTO> expanseList, boolean expanseType,
			double expanseCost, String expanseNote,int orderStatus,int orderType) {
		super();
		this.orderID = orderID;
		this.propertyName = propertyName;
		this.deligatedTenantName = deligatedTenantName;
		this.deligatedTenantPhoneNumber=deligatedTenantPhoneNumber;
		this.propertyRentPrice = propertyRentPrice;
		this.orderStartChargeDate = orderStartChargeDate;
		this.totalAmount = totalAmount;
		this.remainingAmount = remainingAmount;
		this.debtAmount = debtAmount;
		this.totalMonth = totalMonth;
		this.totalDay = totalDay;
		this.expanseList = expanseList;
		this.expanseType = expanseType;
		this.expanseCost = expanseCost;
		this.expanseNote = expanseNote;
		this.orderStatus=orderStatus;
		this.orderType=orderType;
	}
}
