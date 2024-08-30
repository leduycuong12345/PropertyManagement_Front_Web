package com.cuongsolution.manageproperty.front.web.Model.API;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;


public class OrderInfo {
	private long order_Info_ID;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate start_Rental_Date;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate end_Rental_Date;
	@DateTimeFormat(pattern="MM-yyyy")
	private Date order_Belong_Month;
	private double total_Amount;
	private double remaining_Amount;
	private boolean order_Info_Is_Delete=false;
	private Integer total_Day;
	private Integer total_Month;
	private boolean expanse_Type;
	private double expanse_Cost;
	private String expanse_Details;
	private int order_Info_Type;
	
	private List<DetailsRecurringExpanse> detailsRecurringExpanse = new ArrayList<>();
	
	private List<Receipt> receiptList = new ArrayList<>();

	private Worksheet worksheet;

	public Integer getTotal_Day() {
		return total_Day;
	}


	public double getTotal_Amount() {
		return total_Amount;
	}


	public void setTotal_Amount(double total_Amount) {
		this.total_Amount = total_Amount;
	}


	public double getRemaining_Amount() {
		return remaining_Amount;
	}


	public void setRemaining_Amount(double remaining_Amount) {
		this.remaining_Amount = remaining_Amount;
	}	


	public int getOrder_Info_Type() {
		return order_Info_Type;
	}


	public void setOrder_Info_Type(int order_Info_Type) {
		this.order_Info_Type = order_Info_Type;
	}


	public List<Receipt> getReceiptList() {
		return receiptList;
	}


	public void setReceiptList(List<Receipt> receiptList) {
		this.receiptList = receiptList;
	}


	public Date getOrder_Belong_Month() {
		return order_Belong_Month;
	}


	public void setOrder_Belong_Month(Date order_Belong_Month) {
		this.order_Belong_Month = order_Belong_Month;
	}


	public void setTotal_Day(Integer total_Day) {
		this.total_Day = total_Day;
	}

	public Integer getTotal_Month() {
		return total_Month;
	}

	public void setTotal_Month(Integer total_Month) {
		this.total_Month = total_Month;
	}

	public Worksheet getWorksheet() {
		return worksheet;
	}

	public void setWorksheet(Worksheet worksheet) {
		this.worksheet = worksheet;
	}

	

	public LocalDate getStart_Rental_Date() {
		return start_Rental_Date;
	}


	public void setStart_Rental_Date(LocalDate start_Rental_Date) {
		this.start_Rental_Date = start_Rental_Date;
	}


	public LocalDate getEnd_Rental_Date() {
		return end_Rental_Date;
	}


	public void setEnd_Rental_Date(LocalDate end_Rental_Date) {
		this.end_Rental_Date = end_Rental_Date;
	}






	public List<DetailsRecurringExpanse> getDetailsRecurringExpanse() {
		return detailsRecurringExpanse;
	}

	public void setDetailsRecurringExpanse(List<DetailsRecurringExpanse> detailsRecurringExpanse) {
		this.detailsRecurringExpanse = detailsRecurringExpanse;
	}


	public long getOrderInfo_ID() {
		return order_Info_ID;
	}

	public void setOrderInfo_ID(long orderInfo_ID) {
		this.order_Info_ID = orderInfo_ID;
	}

	public boolean isOrder_Info_Is_Delete() {
		return order_Info_Is_Delete;
	}

	public void setOrder_Info_Is_Delete(boolean order_Info_Is_Delete) {
		this.order_Info_Is_Delete = order_Info_Is_Delete;
	}

	public long getOrder_Info_ID() {
		return order_Info_ID;
	}

	public void setOrder_Info_ID(long order_Info_ID) {
		this.order_Info_ID = order_Info_ID;
	}


	public boolean isExpanse_Type() {
		return expanse_Type;
	}

	public void setExpanse_Type(boolean expanse_Type) {
		this.expanse_Type = expanse_Type;
	}

	public double getExpanse_Cost() {
		return expanse_Cost;
	}

	public void setExpanse_Cost(double expanse_Cost) {
		this.expanse_Cost = expanse_Cost;
	}

	public String getExpanse_Details() {
		return expanse_Details;
	}

	public void setExpanse_Details(String expanse_Details) {
		this.expanse_Details = expanse_Details;
	}

	public OrderInfo() {
		super();
	}

	
}
