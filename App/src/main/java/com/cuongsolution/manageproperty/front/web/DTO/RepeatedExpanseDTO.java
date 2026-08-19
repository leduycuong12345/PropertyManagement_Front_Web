package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class RepeatedExpanseDTO {
	private UUID repeatedExpanseID;
	private String repeatedExpanseName;
	private float repeatedExpanseQuantity;
	private double repeatedExpanseCurrentCost;
	private double repeatedExpanseTotalValue;
	private double repeatedExpanseType; //type=1 based on unitCount, type=2 based on totalTenant
	private UUID recurringExpanseID;
	private UUID detailsRecurringExpanseID;
	private UUID unitCountID;
	private String unitCountName;
	
	public double getRepeatedExpanseType() {
		return repeatedExpanseType;
	}
	public void setRepeatedExpanseType(double repeatedExpanseType) {
		this.repeatedExpanseType = repeatedExpanseType;
	}
	public UUID getUnitCountID() {
		return unitCountID;
	}
	public void setUnitCountID(UUID unitCountID) {
		this.unitCountID = unitCountID;
	}
	public String getUnitCountName() {
		return unitCountName;
	}
	public void setUnitCountName(String unitCountName) {
		this.unitCountName = unitCountName;
	}
	public UUID getDetailsRecurringExpanseID() {
		return detailsRecurringExpanseID;
	}
	public void setDetailsRecurringExpanseID(UUID detailsRecurringExpanseID) {
		this.detailsRecurringExpanseID = detailsRecurringExpanseID;
	}
	public double getRepeatedExpanseTotalValue() {
		return repeatedExpanseTotalValue;
	}
	public void setRepeatedExpanseTotalValue(double repeatedExpanseTotalValue) {
		this.repeatedExpanseTotalValue = repeatedExpanseTotalValue;
	}
	public UUID getRepeatedExpanseID() {
		return repeatedExpanseID;
	}
	public void setRepeatedExpanseID(UUID repeatedExpanseID) {
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
	public UUID getRecurringExpanseID() {
		return recurringExpanseID;
	}
	public void setRecurringExpanseID(UUID recurringExpanseID) {
		this.recurringExpanseID = recurringExpanseID;
	}
	public RepeatedExpanseDTO(UUID recurringExpanseID,String repeatedExpanseName, double repeatedExpanseCurrentCost) {
		super();
		this.repeatedExpanseName = repeatedExpanseName;
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
		this.recurringExpanseID = recurringExpanseID;
	}
	
	public RepeatedExpanseDTO() {
		super();
	}
	public RepeatedExpanseDTO(UUID detailsRecurringExpanseID,String repeatedExpanseName,double repeatedExpanseCurrentCost, float repeatedExpanseQuantity,
			 double repeatedExpanseTotalValue ) {
		super();
		this.repeatedExpanseName = repeatedExpanseName;
		this.repeatedExpanseQuantity = repeatedExpanseQuantity;
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
		this.repeatedExpanseTotalValue = repeatedExpanseTotalValue;
		this.detailsRecurringExpanseID = detailsRecurringExpanseID;
	}
	
}
