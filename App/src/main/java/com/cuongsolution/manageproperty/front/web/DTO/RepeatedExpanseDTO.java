package com.cuongsolution.manageproperty.front.web.DTO;

public class RepeatedExpanseDTO {
	private long repeatedExpanseID;
	private String repeatedExpanseName;
	private float repeatedExpanseQuantity;
	private double repeatedExpanseCurrentCost;
	private double repeatedExpanseTotalValue;
	private double repeatedExpanseType; //type=1 based on unitCount, type=2 based on totalTenant
	private long recurringExpanseID;
	private long detailsRecurringExpanseID;
	private long unitCountID;
	private String unitCountName;
	
	public double getRepeatedExpanseType() {
		return repeatedExpanseType;
	}
	public void setRepeatedExpanseType(double repeatedExpanseType) {
		this.repeatedExpanseType = repeatedExpanseType;
	}
	public long getUnitCountID() {
		return unitCountID;
	}
	public void setUnitCountID(long unitCountID) {
		this.unitCountID = unitCountID;
	}
	public String getUnitCountName() {
		return unitCountName;
	}
	public void setUnitCountName(String unitCountName) {
		this.unitCountName = unitCountName;
	}
	public long getDetailsRecurringExpanseID() {
		return detailsRecurringExpanseID;
	}
	public void setDetailsRecurringExpanseID(long detailsRecurringExpanseID) {
		this.detailsRecurringExpanseID = detailsRecurringExpanseID;
	}
	public double getRepeatedExpanseTotalValue() {
		return repeatedExpanseTotalValue;
	}
	public void setRepeatedExpanseTotalValue(double repeatedExpanseTotalValue) {
		this.repeatedExpanseTotalValue = repeatedExpanseTotalValue;
	}
	public long getRepeatedExpanseID() {
		return repeatedExpanseID;
	}
	public void setRepeatedExpanseID(long repeatedExpanseID) {
		this.repeatedExpanseID = repeatedExpanseID;
	}
	public String getRepeatedExpanseName() {
		return repeatedExpanseName;
	}
	
	public void setRepeatedExpanseName(String repeatedExpanseName) {
		this.repeatedExpanseName = repeatedExpanseName;
	}
	public float getRepeatedExpanseQuantity() {
		return repeatedExpanseQuantity;
	}
	public void setRepeatedExpanseQuantity(float repeatedExpanseQuantity) {
		this.repeatedExpanseQuantity = repeatedExpanseQuantity;
	}
	public double getRepeatedExpanseCurrentCost() {
		return repeatedExpanseCurrentCost;
	}
	public void setRepeatedExpanseCurrentCost(double repeatedExpanseCurrentCost) {
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
	}
	public long getRecurringExpanseID() {
		return recurringExpanseID;
	}
	public void setRecurringExpanseID(long recurringExpanseID) {
		this.recurringExpanseID = recurringExpanseID;
	}
	public RepeatedExpanseDTO(long recurringExpanseID,String repeatedExpanseName, double repeatedExpanseCurrentCost) {
		super();
		this.repeatedExpanseName = repeatedExpanseName;
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
		this.recurringExpanseID = recurringExpanseID;
	}
	
	public RepeatedExpanseDTO() {
		super();
	}
	public RepeatedExpanseDTO(long detailsRecurringExpanseID,String repeatedExpanseName,double repeatedExpanseCurrentCost, float repeatedExpanseQuantity,
			 double repeatedExpanseTotalValue ) {
		super();
		this.repeatedExpanseName = repeatedExpanseName;
		this.repeatedExpanseQuantity = repeatedExpanseQuantity;
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
		this.repeatedExpanseTotalValue = repeatedExpanseTotalValue;
		this.detailsRecurringExpanseID = detailsRecurringExpanseID;
	}
	
}
