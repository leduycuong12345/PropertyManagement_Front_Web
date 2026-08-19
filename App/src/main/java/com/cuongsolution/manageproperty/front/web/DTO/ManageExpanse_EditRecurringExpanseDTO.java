package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManageExpanse_EditRecurringExpanseDTO {
	private UUID recurringExpanseID;
	private String recurringExpanseName;
	private float recurringExpansePrice;
	private int recurringExpanseType;
	private UUID recurringExpanseUnitID;
	private List<UUID> selectedPropertyServiceIDList=
			new ArrayList<UUID>();
	public ManageExpanse_EditRecurringExpanseDTO() {
		super();
	}

	public UUID getRecurringExpanseID() {
		return recurringExpanseID;
	}

	public void setRecurringExpanseID(UUID recurringExpanseID) {
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

	

	public UUID getRecurringExpanseUnitID() {
		return recurringExpanseUnitID;
	}

	public void setRecurringExpanseUnitID(UUID recurringExpanseUnitID) {
		this.recurringExpanseUnitID = recurringExpanseUnitID;
	}

	

	public List<UUID> getSelectedPropertyServiceIDList() {
		return selectedPropertyServiceIDList;
	}

	public void setSelectedPropertyServiceIDList(List<UUID> selectedPropertyServiceIDList) {
		this.selectedPropertyServiceIDList = selectedPropertyServiceIDList;
	}

	public ManageExpanse_EditRecurringExpanseDTO(UUID recurringExpanseID, String recurringExpanseName,
			float recurringExpansePrice, int recurringExpanseType, UUID recurringExpanseUnitID,
			List<UUID> selectedPropertyServiceIDList) {
		super();
		this.recurringExpanseID = recurringExpanseID;
		this.recurringExpanseName = recurringExpanseName;
		this.recurringExpansePrice = recurringExpansePrice;
		this.recurringExpanseType = recurringExpanseType;
		this.recurringExpanseUnitID = recurringExpanseUnitID;
		this.selectedPropertyServiceIDList = selectedPropertyServiceIDList;
	}
	

	

	
	
}
