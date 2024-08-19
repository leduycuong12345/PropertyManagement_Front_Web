package com.cuongsolution.manageproperty.front.web.DTO;

public class RepeatedExpanseDTO_AutocompleteSearch {
	private String value;//repeatedExpanseName
	private long repeatedExpanseID;
	private double repeatedExpanseCurrentCost;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public long getRepeatedExpanseID() {
		return repeatedExpanseID;
	}
	public void setRepeatedExpanseID(long repeatedExpanseID) {
		this.repeatedExpanseID = repeatedExpanseID;
	}
	public double getRepeatedExpanseCurrentCost() {
		return repeatedExpanseCurrentCost;
	}
	public void setRepeatedExpanseCurrentCost(double repeatedExpanseCurrentCost) {
		this.repeatedExpanseCurrentCost = repeatedExpanseCurrentCost;
	}
	public RepeatedExpanseDTO_AutocompleteSearch() {
		super();
	}
	
	
}
