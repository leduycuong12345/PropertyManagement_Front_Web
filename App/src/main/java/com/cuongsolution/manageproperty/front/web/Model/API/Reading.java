package com.cuongsolution.manageproperty.front.web.Model.API;
import java.time.LocalDate;


//import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

public class Reading {
	private Long reading_ID;
	//@CreatedDate
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate reading_Date;
	private float reading_Value;
	
	private PropertyService propertyService;
	
	public PropertyService getPropertyService() {
		return propertyService;
	}
	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}
	public Long getReading_ID() {
		return reading_ID;
	}
	public void setReading_ID(Long reading_ID) {
		this.reading_ID = reading_ID;
	}
	
	public LocalDate getReading_Date() {
		return reading_Date;
	}
	public void setReading_Date(LocalDate reading_Date) {
		this.reading_Date = reading_Date;
	}
	public float getReading_Value() {
		return reading_Value;
	}
	public void setReading_Value(float reading_Value) {
		this.reading_Value = reading_Value;
	}
	
	public Reading() {
		super();
	}
	public Reading(Long reading_ID, float reading_Value) {
		super();
		this.reading_ID = reading_ID;
		this.reading_Value = reading_Value;
	}
	public Reading(float reading_Value, PropertyService propertyService) {
		super();
		this.reading_Value = reading_Value;
		this.propertyService = propertyService;
	}
	public Reading(LocalDate reading_Date, float reading_Value, PropertyService propertyService) {
		super();
		this.reading_Date = reading_Date;
		this.reading_Value = reading_Value;
		this.propertyService = propertyService;
	}
	
	
}
