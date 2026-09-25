package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;



public class ManageProperty_Client_FastCreateOrderListDTO {
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderCreateDate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderExpireDate;
	@DateTimeFormat(pattern = "yyyy-MM")
	private String orderBelongMonth;
	private int totalDay;
	private int totalMonth;
	private List<ManageProperty_FastCreateOrderList_WorksheetDTO> worksheetList_withCurrentReading=new ArrayList<ManageProperty_FastCreateOrderList_WorksheetDTO>();
	
	public LocalDate getOrderCreateDate() {
		return orderCreateDate;
	}
	public void setOrderCreateDate(LocalDate orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
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
	
	public LocalDate getOrderExpireDate() {
		return orderExpireDate;
	}
	public void setOrderExpireDate(LocalDate orderExpireDate) {
		this.orderExpireDate = orderExpireDate;
	}
	
	
	
	public String getOrderBelongMonth() {
		return orderBelongMonth;
	}
	public void setOrderBelongMonth(String orderBelongMonth) {
		this.orderBelongMonth = orderBelongMonth;
	}
	public List<ManageProperty_FastCreateOrderList_WorksheetDTO> getWorksheetList_withCurrentReading() {
		return worksheetList_withCurrentReading;
	}
	public void setWorksheetList_withCurrentReading(
			List<ManageProperty_FastCreateOrderList_WorksheetDTO> worksheetList_withCurrentReading) {
		this.worksheetList_withCurrentReading = worksheetList_withCurrentReading;
	}
	public ManageProperty_Client_FastCreateOrderListDTO() {
		super();
	}
	public ManageProperty_Client_FastCreateOrderListDTO(LocalDate orderCreateDate, LocalDate orderExpireDate,
			String orderBelongMonth, int totalMonth, int totalDay,
			List<ManageProperty_FastCreateOrderList_WorksheetDTO> worksheetList_withCurrentReading) {
		super();
		this.orderCreateDate = orderCreateDate;
		this.orderExpireDate = orderExpireDate;
		this.orderBelongMonth = orderBelongMonth;
		this.totalMonth = totalMonth;
		this.totalDay = totalDay;
		this.worksheetList_withCurrentReading = worksheetList_withCurrentReading;
		
		
	}
	
	
	
	
}
