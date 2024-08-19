package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageOrder_ExpanseHeaderDTO {
	private long expanseID;
	private String expanseName;
	private double expansePrice;
	
	
	public long getExpanseID() {
		return expanseID;
	}
	public void setExpanseID(long expanseID) {
		this.expanseID = expanseID;
	}
	public double getExpansePrice() {
		return expansePrice;
	}
	public void setExpansePrice(double expansePrice) {
		this.expansePrice = expansePrice;
	}
	
	public String getExpanseName() {
		return expanseName;
	}
	public void setExpanseName(String expanseName) {
		this.expanseName = expanseName;
	}
	public ManageOrder_ExpanseHeaderDTO() {
		super();
	}
	public ManageOrder_ExpanseHeaderDTO(long expanseID, String expanseName, double expansePrice) {
		super();
		this.expanseID = expanseID;
		this.expanseName = expanseName;
		this.expansePrice = expansePrice;
	}
	
}
