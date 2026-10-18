package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageOrder_ExpanseDTO {
	private UUID detailsExpanseID;
	private double expansePrice;
	private double totalCost;
	private double previousReadingValue;
	private double currentReadingValue;
	private double quantity;
	
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public void setPreviousReadingValue(double previousReadingValue) {
		this.previousReadingValue = previousReadingValue;
	}
	public void setCurrentReadingValue(double currentReadingValue) {
		this.currentReadingValue = currentReadingValue;
	}
	public UUID getDetailsExpanseID() {
		return detailsExpanseID;
	}
	public void setDetailsExpanseID(UUID detailsExpanseID) {
		this.detailsExpanseID = detailsExpanseID;
	}
	public double getExpansePrice() {
		return expansePrice;
	}
	public void setExpansePrice(double expansePrice) {
		this.expansePrice = expansePrice;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getPreviousReadingValue() {
		return previousReadingValue;
	}
	public double getCurrentReadingValue() {
		return currentReadingValue;
	}
	public ManageOrder_ExpanseDTO() {
		super();
	}
	public ManageOrder_ExpanseDTO(UUID detailsExpanseID, double expansePrice, double totalCost,
			double previousReadingValue, double currentReadingValue,double quantity) {
		super();
		this.detailsExpanseID = detailsExpanseID;
		this.expansePrice = expansePrice;
		this.totalCost = totalCost;
		this.previousReadingValue = previousReadingValue;
		this.currentReadingValue = currentReadingValue;
		this.quantity=quantity;
	}
	
}
