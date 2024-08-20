package com.cuongsolution.manageproperty.front.web.Model;

import java.util.ArrayList;
import java.util.List;

public class Property {
	private long PropertyId;
	private String PropertyName;
	private Double PropertyRentalPrice;
	private Integer TenantMax;
	private boolean PropertyIsDelete=false;
	private int PropertyStatus=0;
	
	private Land land;
	
	
	
	private List<Worksheet> worksheetList = new ArrayList<>();
	private List<PropertyService> propertyServiceList = new ArrayList<>();
	
	public Property(long propertyId) {
		super();
		PropertyId = propertyId;
	}

	public List<Worksheet> getWorksheetList() {
		return worksheetList;
	}

	public void setWorksheetList(List<Worksheet> worksheetList) {
		this.worksheetList = worksheetList;
	}


	
	public boolean isPropertyIsDelete() {
		return PropertyIsDelete;
	}

	public void setPropertyIsDelete(boolean propertyIsDelete) {
		PropertyIsDelete = propertyIsDelete;
	}
	
	public Property() {
		super();
		this.PropertyIsDelete=false;
	}
	public String getPropertyName() {
		return PropertyName;
	}
	public void setPropertyName(String propertyName) {
		PropertyName = propertyName;
	}
	
	
	public int getTenantMax() {
		return TenantMax;
	}

	public void setTenantMax(int tenantMax) {
		TenantMax = tenantMax;
	}

	public long getPropertyId() {
		return PropertyId;
	}
	public void setPropertyId(long propertyId) {
		PropertyId = propertyId;
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



	

	public int getPropertyStatus() {
		return PropertyStatus;
	}

	public void setPropertyStatus(int propertyStatus) {
		PropertyStatus = propertyStatus;
	}

	public Property(String propertyName, double PropertyRentalPrice) {
		super();
		PropertyName = propertyName;
		PropertyIsDelete =false;
		this.PropertyRentalPrice =PropertyRentalPrice;
	}


	public Property(long propertyId, String propertyName, Double propertyRentalPrice) {
		super();
		PropertyId = propertyId;
		PropertyName = propertyName;
		PropertyIsDelete =false;
		PropertyRentalPrice = propertyRentalPrice;
	}

	public Double getPropertyRentalPrice() {
		return PropertyRentalPrice;
	}

	public void setPropertyRentalPrice(Double propertyRentalPrice) {
		PropertyRentalPrice = propertyRentalPrice;
	}

	public Property(String propertyName, Double propertyRentalPrice, Land land,int tenantMax) {
		super();
		PropertyName = propertyName;
		PropertyRentalPrice = propertyRentalPrice;
		this.land = land;
		this.TenantMax=tenantMax;
	}

}
