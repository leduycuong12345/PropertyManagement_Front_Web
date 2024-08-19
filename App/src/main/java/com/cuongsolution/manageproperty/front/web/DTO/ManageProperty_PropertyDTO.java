package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ManageProperty_PropertyDTO {
	private long propertyID;
	private String propertyName;
	private double propertyRentalPrice;
	private int worksheettimeInverval;
	private double worksheetTotalDeposit;
	private double worksheetDepositRemaining;
	private int worksheetOrderCreationDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Asia/Bangkok")
	private Date worksheetCreateDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone="Asia/Bangkok")
	private Date worksheetExpireDate;
	private int rentStatus;//0:dang trong 1: dang cho thue 2:da dat coc 
	private int paymentStatus;//0: phòng trống chưa cho thuê,1: phòng đã được đặt cọc,2: phong da co hop-dong-thue nhung chua coc,3:  phong da co hop-dong-thue nhung chua thu tien coc va tien chu ky thang nay,4 phong da co hop-dong-thue da thu du tien coc va tien chu ky thang nay
	private List<ManageProperty_RecurringExpanseDTO> recurringExpanseList=new ArrayList<>();
	
	private long worksheetID;//only init when property_Status != 0 

	public double getWorksheetDepositRemaining() {
		return worksheetDepositRemaining;
	}





	public void setWorksheetDepositRemaining(double worksheetDepositRemaining) {
		this.worksheetDepositRemaining = worksheetDepositRemaining;
	}





	public ManageProperty_PropertyDTO(long propertyID, String propertyName,
			double propertyRentalPrice, int worksheettimeInverval, double worksheetTotalDeposit,
			int worksheetOrderCreationDate, Date worksheetCreateDate, Date worksheetExpireDate, int rentStatus,
			int paymentStatus, List<ManageProperty_RecurringExpanseDTO> recurringExpanseList) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
		this.propertyRentalPrice = propertyRentalPrice;
		this.worksheettimeInverval = worksheettimeInverval;
		this.worksheetTotalDeposit = worksheetTotalDeposit;
		this.worksheetOrderCreationDate = worksheetOrderCreationDate;
		this.worksheetCreateDate = worksheetCreateDate;
		this.worksheetExpireDate = worksheetExpireDate;
		this.rentStatus = rentStatus;
		this.paymentStatus = paymentStatus;
		this.recurringExpanseList = recurringExpanseList;
	}

	public ManageProperty_PropertyDTO(long propertyID, String propertyName,
			double propertyRentalPrice, int worksheettimeInverval, double worksheetTotalDeposit,
			int worksheetOrderCreationDate, Date worksheetCreateDate, Date worksheetExpireDate, int rentStatus,
			int paymentStatus, List<ManageProperty_RecurringExpanseDTO> recurringExpanseList
			,long worksheetID,double worksheetDepositRemaining) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
		this.propertyRentalPrice = propertyRentalPrice;
		this.worksheettimeInverval = worksheettimeInverval;
		this.worksheetTotalDeposit = worksheetTotalDeposit;
		this.worksheetOrderCreationDate = worksheetOrderCreationDate;
		this.worksheetCreateDate = worksheetCreateDate;
		this.worksheetExpireDate = worksheetExpireDate;
		this.rentStatus = rentStatus;
		this.paymentStatus = paymentStatus;
		this.recurringExpanseList = recurringExpanseList;
		this.worksheetID=worksheetID;
		this.worksheetDepositRemaining=worksheetDepositRemaining;
	}
	public List<ManageProperty_RecurringExpanseDTO> getRecurringExpanseList() {
		return recurringExpanseList;
	}
	public long getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(long worksheetID) {
		this.worksheetID = worksheetID;
	}
	public void setRecurringExpanseList(List<ManageProperty_RecurringExpanseDTO> recurringExpanseList) {
		this.recurringExpanseList = recurringExpanseList;
	}





	public int getRentStatus() {
		return rentStatus;
	}



	public void setRentStatus(int rentStatus) {
		this.rentStatus = rentStatus;
	}



	public int getPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	public int getWorksheetOrderCreationDate() {
		return worksheetOrderCreationDate;
	}



	public void setWorksheetOrderCreationDate(int worksheetOrderCreationDate) {
		this.worksheetOrderCreationDate = worksheetOrderCreationDate;
	}



	



	public int getWorksheettimeInverval() {
		return worksheettimeInverval;
	}



	public void setWorksheettimeInverval(int worksheettimeInverval) {
		this.worksheettimeInverval = worksheettimeInverval;
	}



	public double getWorksheetTotalDeposit() {
		return worksheetTotalDeposit;
	}



	public void setWorksheetTotalDeposit(double worksheetTotalDeposit) {
		this.worksheetTotalDeposit = worksheetTotalDeposit;
	}





	public ManageProperty_PropertyDTO(long propertyID, String propertyName) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
	}



	public ManageProperty_PropertyDTO(long propertyID, String propertyName, double propertyRentalPrice) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
		this.propertyRentalPrice = propertyRentalPrice;
	}


	public ManageProperty_PropertyDTO() {
		super();
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



	public double getPropertyRentalPrice() {
		return propertyRentalPrice;
	}


	public void setPropertyRentalPrice(double propertyRentalPrice) {
		this.propertyRentalPrice = propertyRentalPrice;
	}

	public long getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}



	public ManageProperty_PropertyDTO(long propertyID, String propertyName, double propertyRentalPrice,
			 double worksheetTotalDeposit, int worksheetOrderCreationDate,int worksheettimeInverval) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
		this.propertyRentalPrice = propertyRentalPrice;
		this.worksheettimeInverval = worksheettimeInverval;
		this.worksheetTotalDeposit = worksheetTotalDeposit;
		this.worksheetOrderCreationDate = worksheetOrderCreationDate;
	}


}
