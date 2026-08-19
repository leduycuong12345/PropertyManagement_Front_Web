package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManageExpanse_CreateRecurringExpanseDTO {
	private UUID landID;
	private String recurringExpanseName;
	private float recurringExpansePrice;
	private int recurringExpanseType;
	private UUID recurringExpanseUnitID;
	private List<UUID> selectedPropertyIDList=
			new ArrayList<UUID>();
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

	

	public UUID getRecurringExpanseUnitID() {
		return recurringExpanseUnitID;
	}

	public void setRecurringExpanseUnitID(UUID recurringExpanseUnitID) {
		this.recurringExpanseUnitID = recurringExpanseUnitID;
	}
	

	public UUID getLandID() {
		return landID;
	}



	public void setLandID(UUID landID) {
		this.landID = landID;
	}



	public List<UUID> getSelectedPropertyIDList() {
		return selectedPropertyIDList;
	}



	public void setSelectedPropertyIDList(List<UUID> selectedPropertyIDList) {
		this.selectedPropertyIDList = selectedPropertyIDList;
	}

}
