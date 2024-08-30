package com.cuongsolution.manageproperty.front.web.Model.API;
import java.util.ArrayList;
import java.util.List;


public class PropertyService {
	private Long propertyService_ID;
	
	private boolean propertyServiceIsDelete=false;

	private Property property;
	
	private RecurringExpanse recurringExpanse;
	
	private List<Reading> readingList = new ArrayList<>();
	
	private List<DetailsRecurringExpanse> detailsRecurringExpanseList = new ArrayList<>();
	
	public List<Reading> getReadingList() {
		return readingList;
	}
	public void setReadingList(List<Reading> readingList) {
		this.readingList = readingList;
	}
	
	public List<DetailsRecurringExpanse> getDetailsRecurringExpanseList() {
		return detailsRecurringExpanseList;
	}
	public void setDetailsRecurringExpanseList(List<DetailsRecurringExpanse> detailsRecurringExpanseList) {
		this.detailsRecurringExpanseList = detailsRecurringExpanseList;
	}
	public Long getPropertyService_ID() {
		return propertyService_ID;
	}
	public void setPropertyService_ID(Long propertyService_ID) {
		this.propertyService_ID = propertyService_ID;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public boolean isPropertyServiceIsDelete() {
		return propertyServiceIsDelete;
	}
	public void setPropertyServiceIsDelete(boolean propertyServiceIsDelete) {
		this.propertyServiceIsDelete = propertyServiceIsDelete;
	}
	public RecurringExpanse getRecurringExpanse() {
		return recurringExpanse;
	}
	public void setRecurringExpanse(RecurringExpanse recurringExpanse) {
		this.recurringExpanse = recurringExpanse;
	}
	
	public PropertyService() {
		super();
	}
	public PropertyService( Property property, RecurringExpanse recurring_Expanse) {
		super();
		this.property = property;
		recurringExpanse = recurring_Expanse;
	}
	
}
