package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageCharts_PropertyRateChart {
	private int emptyPropertyIndex; //Pie chart 1
	private int hiredPropertyIndex; //Pie chart 1
	private int bookedPropertyIndex; //Pie chart  1
	public int getEmptyPropertyIndex() {
		return emptyPropertyIndex;
	}
	public void setEmptyPropertyIndex(int emptyPropertyIndex) {
		this.emptyPropertyIndex = emptyPropertyIndex;
	}
	public int getHiredPropertyIndex() {
		return hiredPropertyIndex;
	}
	public void setHiredPropertyIndex(int hiredPropertyIndex) {
		this.hiredPropertyIndex = hiredPropertyIndex;
	}
	public int getBookedPropertyIndex() {
		return bookedPropertyIndex;
	}
	public void setBookedPropertyIndex(int bookedPropertyIndex) {
		this.bookedPropertyIndex = bookedPropertyIndex;
	}
	public ManageCharts_PropertyRateChart(int emptyPropertyIndex, int hiredPropertyIndex, int bookedPropertyIndex) {
		super();
		this.emptyPropertyIndex = emptyPropertyIndex;
		this.hiredPropertyIndex = hiredPropertyIndex;
		this.bookedPropertyIndex = bookedPropertyIndex;
	}
	
}
