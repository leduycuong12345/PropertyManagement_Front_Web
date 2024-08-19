package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;

public class ManageExpanse_EditRecurringExpanseDTO {
	private long recurringExpanseID;
	private String recurringExpanseName;
	private float recurringExpansePrice;
	private int recurringExpanseType;
	private long recurringExpanseUnitID;
	private List<Long> selectedPropertyServiceIDList=
			new ArrayList<Long>();
	public ManageExpanse_EditRecurringExpanseDTO() {
		super();
	}

	public long getRecurringExpanseID() {
		return recurringExpanseID;
	}

	public void setRecurringExpanseID(long recurringExpanseID) {
		this.recurringExpanseID = recurringExpanseID;
	}
	

	public String getRecurringExpanseName() {
		return recurringExpanseName;
	}

	public void setRecurringExpanseName(String recurringExpanseName) {
		this.recurringExpanseName = recurringExpanseName;
	}

	public float getRecurringExpansePrice() {
		return recurringExpansePrice;
	}

	public void setRecurringExpansePrice(float recurringExpansePrice) {
		this.recurringExpansePrice = recurringExpansePrice;
	}

	public int getRecurringExpanseType() {
		return recurringExpanseType;
	}

	public void setRecurringExpanseType(int recurringExpanseType) {
		this.recurringExpanseType = recurringExpanseType;
	}

	

	public long getRecurringExpanseUnitID() {
		return recurringExpanseUnitID;
	}

	public void setRecurringExpanseUnitID(long recurringExpanseUnitID) {
		this.recurringExpanseUnitID = recurringExpanseUnitID;
	}

	

	public List<Long> getSelectedPropertyServiceIDList() {
		return selectedPropertyServiceIDList;
	}

	public void setSelectedPropertyServiceIDList(List<Long> selectedPropertyServiceIDList) {
		this.selectedPropertyServiceIDList = selectedPropertyServiceIDList;
	}

	public ManageExpanse_EditRecurringExpanseDTO(long recurringExpanseID, String recurringExpanseName,
			float recurringExpansePrice, int recurringExpanseType, long recurringExpanseUnitID,
			List<Long> selectedPropertyServiceIDList) {
		super();
		this.recurringExpanseID = recurringExpanseID;
		this.recurringExpanseName = recurringExpanseName;
		this.recurringExpansePrice = recurringExpansePrice;
		this.recurringExpanseType = recurringExpanseType;
		this.recurringExpanseUnitID = recurringExpanseUnitID;
		this.selectedPropertyServiceIDList = selectedPropertyServiceIDList;
	}
	

	

	
	
}
