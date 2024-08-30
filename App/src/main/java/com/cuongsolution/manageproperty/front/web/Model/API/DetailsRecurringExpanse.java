package com.cuongsolution.manageproperty.front.web.Model.API;

public class DetailsRecurringExpanse {
	 private long details_Recurring_Expanse_ID;
	 
	 private OrderInfo orderInfo;

	 private float recurring_Expanse_Quantity;
	 private double recurring_Expanse_Total;
	 private float recurring_Expanse_Last_Record;
	 private double current_Repeated_Expanse_Cost;

	 private PropertyService propertyService;
	
	public DetailsRecurringExpanse() {
		super();
	}

	




	public PropertyService getPropertyService() {
		return propertyService;
	}






	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}






	public float getRecurring_Expanse_Quantity() {
		return recurring_Expanse_Quantity;
	}




	public void setRecurring_Expanse_Quantity(float recurring_Expanse_Quantity) {
		this.recurring_Expanse_Quantity = recurring_Expanse_Quantity;
	}




	public double getRecurring_Expanse_Total() {
		return recurring_Expanse_Total;
	}




	public float getRecurring_Expanse_Last_Record() {
		return recurring_Expanse_Last_Record;
	}






	public void setRecurring_Expanse_Last_Record(float recurring_Expanse_Last_Record) {
		this.recurring_Expanse_Last_Record = recurring_Expanse_Last_Record;
	}






	public void setRecurring_Expanse_Total(double recurring_Expanse_Total) {
		this.recurring_Expanse_Total = recurring_Expanse_Total;
	}




	public double getCurrent_Repeated_Expanse_Cost() {
		return current_Repeated_Expanse_Cost;
	}

	public void setCurrent_Repeated_Expanse_Cost(double current_Repeated_Expanse_Cost) {
		this.current_Repeated_Expanse_Cost = current_Repeated_Expanse_Cost;
	}




	public long getDetails_Recurring_Expanse_ID() {
		return details_Recurring_Expanse_ID;
	}




	public void setDetails_Recurring_Expanse_ID(long details_Recurring_Expanse_ID) {
		this.details_Recurring_Expanse_ID = details_Recurring_Expanse_ID;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}




	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}



	public DetailsRecurringExpanse(OrderInfo orderInfo, float recurring_Expanse_Quantity,
			double recurring_Expanse_Total, float recurring_Expanse_Last_Record, double current_Repeated_Expanse_Cost,
			PropertyService propertyService) {
		super();
		this.orderInfo = orderInfo;
		this.recurring_Expanse_Quantity = recurring_Expanse_Quantity;
		this.recurring_Expanse_Total = recurring_Expanse_Total;
		this.recurring_Expanse_Last_Record = recurring_Expanse_Last_Record;
		this.current_Repeated_Expanse_Cost = current_Repeated_Expanse_Cost;
		this.propertyService = propertyService;
	}





}
