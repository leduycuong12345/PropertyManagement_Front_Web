package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageProperty_ReadingDTO {
	private UUID reading_ID;
	private double readingValue;
	public UUID getReading_ID() {
		return reading_ID;
	}
	public void setReading_ID(UUID reading_ID) {
		this.reading_ID = reading_ID;
	}
	
	public double getReadingValue() {
		return readingValue;
	}
	public void setReadingValue(double readingValue) {
		this.readingValue = readingValue;
	}
	
	public ManageProperty_ReadingDTO(UUID reading_ID, double readingValue) {
		super();
		this.reading_ID = reading_ID;
		this.readingValue = readingValue;
	}
	public ManageProperty_ReadingDTO() {
		super();
	}
	
}
