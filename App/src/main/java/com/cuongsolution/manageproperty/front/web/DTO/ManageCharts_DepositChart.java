package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageCharts_DepositChart {
	private int paidDepositWorksheetIndex; //Pie chart 1 
	private int unpaidDepositWorksheetIndex; //Pie chart 1
	private double paidDepositAmount; //Pie chart 2 
	private double unpaidDepositAmount; //Pie chart 2
	
	public int getPaidDepositWorksheetIndex() {
		return paidDepositWorksheetIndex;
	}
	public void setPaidDepositWorksheetIndex(int paidDepositWorksheetIndex) {
		this.paidDepositWorksheetIndex = paidDepositWorksheetIndex;
	}
	public int getUnpaidDepositWorksheetIndex() {
		return unpaidDepositWorksheetIndex;
	}
	public void setUnpaidDepositWorksheetIndex(int unpaidDepositWorksheetIndex) {
		this.unpaidDepositWorksheetIndex = unpaidDepositWorksheetIndex;
	}
	public double getPaidDepositAmount() {
		return paidDepositAmount;
	}
	public void setPaidDepositAmount(double paidDepositAmount) {
		this.paidDepositAmount = paidDepositAmount;
	}
	public double getUnpaidDepositAmount() {
		return unpaidDepositAmount;
	}
	public void setUnpaidDepositAmount(double unpaidDepositAmount) {
		this.unpaidDepositAmount = unpaidDepositAmount;
	}
	
}
