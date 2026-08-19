package com.cuongsolution.manageproperty.front.web.DTO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ManageExpanse_RecurringExpanseDTO {
	private UUID recurringExpanseID;
	private String recurringExpanseName;
	private float recurringExpansePrice;
	private int recurringExpanseType;
	private UUID recurringExpanseUnitID;
	private String recurringExpanseUnitName;
	private int totalAppliedProperty;
	private List<ManageExpanse_PropertyServiceDTO> propertyServiceList=
			new ArrayList<ManageExpanse_PropertyServiceDTO>();
	public ManageExpanse_RecurringExpanseDTO() {
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

	public String getRecurringExpanseUnitName() {
		return recurringExpanseUnitName;
	}

	public void setRecurringExpanseUnitName(String recurringExpanseUnitName) {
		this.recurringExpanseUnitName = recurringExpanseUnitName;
	}

	public int getTotalAppliedProperty() {
		return totalAppliedProperty;
	}

	public void setTotalAppliedProperty(int totalAppliedProperty) {
		this.totalAppliedProperty = totalAppliedProperty;
	}

	public List<ManageExpanse_PropertyServiceDTO> getPropertyServiceList() {
		return propertyServiceList;
	}

	public void setPropertyServiceList(List<ManageExpanse_PropertyServiceDTO> propertyServiceList) {
		this.propertyServiceList = propertyServiceList;
	}

	public ManageExpanse_RecurringExpanseDTO(UUID recurringExpanseID, String recurringExpanseName,
			float recurringExpansePrice, int recurringExpanseType, UUID recurringExpanseUnitID,
			String recurringExpanseUnitName, int totalAppliedProperty,
			List<ManageExpanse_PropertyServiceDTO> propertyServiceList) {
		super();
		this.recurringExpanseID = recurringExpanseID;
		this.recurringExpanseName = recurringExpanseName;
		this.recurringExpansePrice = recurringExpansePrice;
		this.recurringExpanseType = recurringExpanseType;
		this.recurringExpanseUnitID = recurringExpanseUnitID;
		this.recurringExpanseUnitName = recurringExpanseUnitName;
		this.totalAppliedProperty = totalAppliedProperty;
		this.propertyServiceList = propertyServiceList;
	}

	

	

	
	
}
