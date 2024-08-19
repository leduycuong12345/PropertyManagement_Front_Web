package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;

public class ManageExpanse_CreateRecurringExpanseDTO {
	private long landID;
	private String recurringExpanseName;
	private float recurringExpansePrice;
	private int recurringExpanseType;
	private long recurringExpanseUnitID;
	private List<Long> selectedPropertyIDList=
			new ArrayList<Long>();
	public ManageExpanse_CreateRecurringExpanseDTO() {
		super();
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
	

	public long getLandID() {
		return landID;
	}



	public void setLandID(long landID) {
		this.landID = landID;
	}



	public List<Long> getSelectedPropertyIDList() {
		return selectedPropertyIDList;
	}



	public void setSelectedPropertyIDList(List<Long> selectedPropertyIDList) {
		this.selectedPropertyIDList = selectedPropertyIDList;
	}

}
