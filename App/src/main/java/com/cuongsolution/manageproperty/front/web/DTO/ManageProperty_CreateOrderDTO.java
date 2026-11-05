package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ManageProperty_CreateOrderDTO {
	private UUID worksheetID;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderCreateDate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderExpireDate;
	//@DateTimeFormat(pattern = "yyyy-MM")
	//private Date orderBelongMonth;
	@JsonFormat(pattern = "yyyy-MM")
	private YearMonth  orderBelongMonth;
	private int totalMonth;
	private int totalDay;
	private Double totalCost;
	private List<ManageProperty_CreateOrder_RecurringExpanseDTO> recurringExpanseList_withCurrentReading=new ArrayList<ManageProperty_CreateOrder_RecurringExpanseDTO>();//at the client-side , form post ll send a string that content object[id:long,value:float] as "object.id,object.value"
	private boolean expanseType;// Cong-them hoac /tru-vao
	private Double expanseCost;
	private String expanseDetails;
	
	public UUID getWorksheetID() {
		return worksheetID;
	}
	public void setWorksheetID(UUID worksheetID) {
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
	public YearMonth  getOrderBelongMonth() {
		return orderBelongMonth;
	}
	public void setOrderBelongMonth(YearMonth  orderBelongMonth) {
		this.orderBelongMonth = orderBelongMonth;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	public List<ManageProperty_CreateOrder_RecurringExpanseDTO> getRecurringExpanseList_withCurrentReading() {
		return recurringExpanseList_withCurrentReading;
	}
	public void setRecurringExpanseList_withCurrentReading(List<ManageProperty_CreateOrder_RecurringExpanseDTO> recurringExpanseList_withCurrentReading) {
		this.recurringExpanseList_withCurrentReading = recurringExpanseList_withCurrentReading;
	}
	public boolean isExpanseType() {
		return expanseType;
	}
	public void setExpanseType(boolean expanseType) {
		this.expanseType = expanseType;
	}
	public Double getExpanseCost() {
		return expanseCost;
	}
	public void setExpanseCost(Double expanseCost) {
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
	/*public ManageProperty_CreateOrderDTO(ManageProperty_CreateOrderDTO newOrder) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.parsedOrderBelongMonth= LocalDate.parse(client_DTO.getOrderBelongMonth()+"-01", formatter);
        
        this.orderCreateDate = newOrder.getOrderCreateDate();
		this.orderExpireDate = newOrder.getOrderExpireDate();
		this.totalMonth = newOrder.getTotalMonth();
		this.totalDay = newOrder.getTotalDay();
		this.worksheetList_withCurrentReading = newOrder.get();
		
		private UUID worksheetID;
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		private LocalDate orderCreateDate;
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		private LocalDate orderExpireDate;
		//@DateTimeFormat(pattern = "yyyy-MM")
		//private Date orderBelongMonth;
		@JsonFormat(pattern = "yyyy-MM")
		private YearMonth  orderBelongMonth;
		private int totalMonth;
		private int totalDay;
		private double totalCost;
		private List<ManageProperty_CreateOrder_RecurringExpanseDTO> recurringExpanseList_withCurrentReading=new ArrayList<ManageProperty_CreateOrder_RecurringExpanseDTO>();//at the client-side , form post ll send a string that content object[id:long,value:float] as "object.id,object.value"
		private boolean expanseType;// Cong-them hoac /tru-vao
		private double expanseCost;
		private String expanseDetails;
	}*/
	
	
	
	
}
