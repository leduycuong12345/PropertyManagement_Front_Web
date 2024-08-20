package com.cuongsolution.manageproperty.front.web.Model;
import java.util.ArrayList;
import java.util.List;

public class RecurringExpanseUnit {
	private long recurring_Expanse_Unit_ID;
	private String recurring_Expanse_Unit_Name;

	private List<RecurringExpanse> recurringExpanseList = new ArrayList<>();
	
	public long getRecurring_Expanse_Unit_ID() {
		return recurring_Expanse_Unit_ID;
	}

	public void setRecurring_Expanse_Unit_ID(long recurring_Expanse_Unit_ID) {
		this.recurring_Expanse_Unit_ID = recurring_Expanse_Unit_ID;
	}

	public String getRecurring_Expanse_Unit_Name() {
		return recurring_Expanse_Unit_Name;
	}

	public void setRecurring_Expanse_Unit_Name(String recurring_Expanse_Unit_Name) {
		this.recurring_Expanse_Unit_Name = recurring_Expanse_Unit_Name;
	}

	public RecurringExpanseUnit() {
		super();
	}
	
}
