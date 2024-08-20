package com.cuongsolution.manageproperty.front.web.Model;
import java.util.ArrayList;
import java.util.List;

public class RecurringExpanse {
	private Long recurring_Expanse_ID;
	
	private String Recurring_Expanse_Name;
	private int Recurring_Expanse_Type;
	private float Recurring_Expanse_Price;
	private Land land;

	private List<PropertyService> propertyServiceList = new ArrayList<>();
	private boolean recurringExpanseIsDelete=false;
	
	private RecurringExpanseUnit recurringExpanseCountUnit;
	public boolean isRecurringExpanseIsDelete() {
		return recurringExpanseIsDelete;
	}
	

	public String getRecurring_Expanse_Name() {
		return Recurring_Expanse_Name;
	}


	public void setRecurring_Expanse_Name(String recurring_Expanse_Name) {
		Recurring_Expanse_Name = recurring_Expanse_Name;
	}


	public int getRecurring_Expanse_Type() {
		return Recurring_Expanse_Type;
	}

	public void setRecurring_Expanse_Type(int recurring_Expanse_Type) {
		Recurring_Expanse_Type = recurring_Expanse_Type;
	}

	public RecurringExpanseUnit getRecurringExpanseCountUnit() {
		return recurringExpanseCountUnit;
	}

	public void setRecurringExpanseCountUnit(RecurringExpanseUnit recurringExpanseCountUnit) {
		this.recurringExpanseCountUnit = recurringExpanseCountUnit;
	}

	public void setRecurringExpanseIsDelete(boolean recurringExpanseIsDelete) {
		this.recurringExpanseIsDelete = recurringExpanseIsDelete;
	}
	public List<PropertyService> getPropertyServiceList() {
		return propertyServiceList;
	}
	public void setPropertyServiceList(List<PropertyService> propertyServiceList) {
		this.propertyServiceList = propertyServiceList;
	}
	public Land getLand() {
		return land;
	}
	public void setLand(Land land) {
		this.land = land;
	}
	public float getRecurring_Expanse_Price() {
		return Recurring_Expanse_Price;
	}
	public void setRecurring_Expanse_Price(float recurring_Expanse_Price) {
		Recurring_Expanse_Price = recurring_Expanse_Price;
	}
	public Long getRecurring_Expanse_ID() {
		return recurring_Expanse_ID;
	}
	public void setRecurring_Expanse_ID(Long recurring_Expanse_ID) {
		this.recurring_Expanse_ID = recurring_Expanse_ID;
	}
	
	public RecurringExpanse() {
		super();
	}
	public RecurringExpanse(Long recurring_Expanse_ID) {
		super();
		this.recurring_Expanse_ID = recurring_Expanse_ID;
	}
	// luồng sequences create-fast-land: tạo liên kết giữa expanse và land để xóa và thêm chức năng
	
	public RecurringExpanse( RecurringExpanseUnit recurringExpanseCountUnit
		,	float recurring_Expanse_Price, Land land) {
		super();
		this.recurringExpanseCountUnit=recurringExpanseCountUnit;
		Recurring_Expanse_Price = recurring_Expanse_Price;
		this.land = land;
	}

	public RecurringExpanse(String recurring_Expanse_Name, int recurring_Expanse_Type, float recurring_Expanse_Price,
			Land land, RecurringExpanseUnit recurringExpanseCountUnit) {
		super();
		Recurring_Expanse_Name = recurring_Expanse_Name;
		Recurring_Expanse_Type = recurring_Expanse_Type;
		Recurring_Expanse_Price = recurring_Expanse_Price;
		this.land = land;
		this.recurringExpanseCountUnit = recurringExpanseCountUnit;
	}
	
	
	
	
}
