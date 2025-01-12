package com.cuongsolution.manageproperty.front.web.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ManageProperty_FastCreateOrderListDTO {
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderCreateDate;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate orderExpireDate;
	@DateTimeFormat(pattern = "yyyy-MM")
	private String orderBelongMonth;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate parsedOrderBelongMonth ;
	private int totalMonth;
	public LocalDate getOrderCreateDate() {
		return orderCreateDate;
	}
	public void setOrderCreateDate(LocalDate orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}
	private int totalDay;
	private List<ManageProperty_FastCreateOrderList_WorksheetDTO> worksheetList_withCurrentReading=new ArrayList<ManageProperty_FastCreateOrderList_WorksheetDTO>();
	
	
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
	
	public LocalDate getParsedOrderCreateDate() {
		return orderCreateDate;
	}
	public void setParsedOrderCreateDate(LocalDate orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
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
	public LocalDate getParsedOrderBelongMonth() {
		return parsedOrderBelongMonth;
	}
	public void setParsedOrderBelongMonth(String orderBelongMonth) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.parsedOrderBelongMonth= LocalDate.parse(orderBelongMonth+"-01", formatter);
	}
	public void setWorksheetList_withCurrentReading(
			List<ManageProperty_FastCreateOrderList_WorksheetDTO> worksheetList_withCurrentReading) {
		this.worksheetList_withCurrentReading = worksheetList_withCurrentReading;
	}
	public ManageProperty_FastCreateOrderListDTO() {
		super();
	}
	public ManageProperty_FastCreateOrderListDTO(LocalDate orderCreateDate, LocalDate orderExpireDate,
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
