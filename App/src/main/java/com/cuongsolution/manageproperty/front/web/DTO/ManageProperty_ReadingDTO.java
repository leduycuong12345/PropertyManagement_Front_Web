package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageProperty_ReadingDTO {
	private long reading_ID;
	private double readingValue;
	public long getReading_ID() {
		return reading_ID;
	}
	public void setReading_ID(long reading_ID) {
		this.reading_ID = reading_ID;
	}
	
	public double getReadingValue() {
		return readingValue;
	}
	public void setReadingValue(double readingValue) {
		this.readingValue = readingValue;
	}
	
	public ManageProperty_ReadingDTO(long reading_ID, double readingValue) {
		super();
		this.reading_ID = reading_ID;
		this.readingValue = readingValue;
	}
	public ManageProperty_ReadingDTO() {
		super();
	}
	
}
