package com.cuongsolution.manageproperty.front.web.DTO;
public class RepeatedExpanseTypeMeterWatchDTO {
	private long repeatedExpanseID;
	private String repeatedExpanseName;
	private float previousReading;
	private float currentReading;
	private double repeatedExpanseCurrentCost;
	private double repeatedExpanseTotal;
	private long recurringExpanseID;
	private long detailsRecurringExpanseID;
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
	public float getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(float previousReading) {
		this.previousReading = previousReading;
	}
	public float getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(float currentReading) {
		this.currentReading = currentReading;
	}
	public double getRepeatedExpanseCurrentCost() {
		return repeatedExpanseCurrentCost;
	}
	public void setRepeatedExpanseCurrentCost(double repeatedExpanseCurrentCost) {
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
	}
	public double getRepeatedExpanseTotal() {
		return repeatedExpanseTotal;
	}
	public void setRepeatedExpanseTotal(double repeatedExpanseTotal) {
		this.repeatedExpanseTotal = repeatedExpanseTotal;
	}
	public long getRecurringExpanseID() {
		return recurringExpanseID;
	}
	public void setRecurringExpanseID(long recurringExpanseID) {
		this.recurringExpanseID = recurringExpanseID;
	}
	public long getDetailsRecurringExpanseID() {
		return detailsRecurringExpanseID;
	}
	public void setDetailsRecurringExpanseID(long detailsRecurringExpanseID) {
		this.detailsRecurringExpanseID = detailsRecurringExpanseID;
	}
	public RepeatedExpanseTypeMeterWatchDTO(long repeatedExpanseID, String repeatedExpanseName, float previousReading,
			float currentReading, double repeatedExpanseCurrentCost) {
		super();
		this.repeatedExpanseID = repeatedExpanseID;
		this.repeatedExpanseName = repeatedExpanseName;
		this.previousReading = previousReading;
		this.currentReading = currentReading;
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
	}
	
}
