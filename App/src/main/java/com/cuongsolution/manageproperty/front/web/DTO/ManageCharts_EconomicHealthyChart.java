package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageCharts_EconomicHealthyChart {
	private int paidWorksheetIndex; //Pie chart 1
	private int onDebtWorksheetIndex; //Pie chart 1
	private double paidAmount; //Pie chart 2
	private double debtAmount; //Pie chart 2
	
	public int getPaidWorksheetIndex() {
		return paidWorksheetIndex;
	}
	public void setPaidWorksheetIndex(int paidWorksheetIndex) {
		this.paidWorksheetIndex = paidWorksheetIndex;
	}
	public int getOnDebtWorksheetIndex() {
		return onDebtWorksheetIndex;
	}
	public void setOnDebtWorksheetIndex(int onDebtWorksheetIndex) {
		this.onDebtWorksheetIndex = onDebtWorksheetIndex;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public double getDebtAmount() {
		return debtAmount;
	}
	public void setDebtAmount(double debtAmount) {
		this.debtAmount = debtAmount;
	}
	
} 
