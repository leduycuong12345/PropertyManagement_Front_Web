package com.cuongsolution.manageproperty.front.web.DTO;


public class ManageOrder_ManageExpanse_DatePaginationDTO {
	private final int totalMonthInYear=12;//always 12 baby
	private int currentMonth=1;
	private int currentYear=2023;
	
	
	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	
	public int getCurrentMonth() {
		return currentMonth;
	}
	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}
	public int getTotalMonthInYear() {
		return totalMonthInYear;
	}

	public ManageOrder_ManageExpanse_DatePaginationDTO() {
		super();
		
	}

	public ManageOrder_ManageExpanse_DatePaginationDTO(int currentMonth, int currentYear) {
		super();
		this.currentMonth = currentMonth;
		this.currentYear = currentYear;
	}
	
}
