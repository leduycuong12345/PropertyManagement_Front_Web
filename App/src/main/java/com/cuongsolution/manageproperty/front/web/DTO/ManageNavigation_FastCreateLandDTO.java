package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageNavigation_FastCreateLandDTO {
	private long landID;
	private String landName="";
	private int orderCreationDate=1;//must be in 0<x<31 
	private int floorCount=0;
	private int propertyCountEachFloor=0;
	private int waterExpanseType=-1;
	private int electricExpanseType=-1;
	private int trashExpanseType=-1;
	private int ethernetExpanseType=-1;
	private double propertyRentalPrice=0.0;
	private Integer tenantMax=1;
	private String landAddress;
	private String landAddressRegion;
	private String landAddressPostcode;
	private String countryCode;
	private double landLat;
	private double landLng;
	
	
	public String getLandAddressRegion() {
		return landAddressRegion;
	}




	public void setLandAddressRegion(String landAddressRegion) {
		this.landAddressRegion = landAddressRegion;
	}




	public String getLandAddressPostcode() {
		return landAddressPostcode;
	}




	public void setLandAddressPostcode(String landAddressPostcode) {
		this.landAddressPostcode = landAddressPostcode;
	}




	public String getCountryCode() {
		return countryCode;
	}




	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}




	public double getLandLat() {
		return landLat;
	}




	public void setLandLat(double landLat) {
		this.landLat = landLat;
	}




	public double getLandLng() {
		return landLng;
	}




	public void setLandLng(double landLng) {
		this.landLng = landLng;
	}




	public ManageNavigation_FastCreateLandDTO(long landID, String landName ,double propertyRentalPrice, int orderCreationDate
			,String landAddress,String landAddressPostcode
			) {
		super();
		this.landID = landID;
		this.landName = landName;
		this.orderCreationDate = orderCreationDate;
		this.propertyRentalPrice = propertyRentalPrice;
		this.landAddress=landAddress;
		this.landAddressPostcode=landAddressPostcode;
	}
	
	


	public String getLandAddress() {
		return landAddress;
	}




	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}




	public Integer getTenantMax() {
		return tenantMax;
	}




	public void setTenantMax(Integer tenantMax) {
		this.tenantMax = tenantMax;
	}




	public long getLandID() {
		return landID;
	}
	public void setLandID(long landID) {
		this.landID = landID;
	}
	public String getLandName() {
		return landName;
	}
	public void setLandName(String landName) {
		this.landName = landName;
	}
	public int getOrderCreationDate() {
		return orderCreationDate;
	}
	public void setOrderCreationDate(int orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}
	
	public int getFloorCount() {
		return floorCount;
	}
	public void setFloorCount(int floorCount) {
		this.floorCount = floorCount;
	}
	public int getPropertyCountEachFloor() {
		return propertyCountEachFloor;
	}
	public void setPropertyCountEachFloor(int propertyCountEachFloor) {
		this.propertyCountEachFloor = propertyCountEachFloor;
	}
	
	public double getPropertyRentalPrice() {
		return propertyRentalPrice;
	}
	
	public ManageNavigation_FastCreateLandDTO() {
		super();
	}
	
	
	public int getWaterExpanseType() {
		return waterExpanseType;
	}
	public int getTrashExpanseType() {
		return trashExpanseType;
	}
	public void setTrashExpanseType(int trashExpanseType) {
		this.trashExpanseType = trashExpanseType;
	}
	public int getEthernetExpanseType() {
		return ethernetExpanseType;
	}
	public void setEthernetExpanseType(int ethernetExpanseType) {
		this.ethernetExpanseType = ethernetExpanseType;
	}
	public void setWaterExpanseType(int waterExpanseType) {
		this.waterExpanseType = waterExpanseType;
	}
	public int getElectricExpanseType() {
		return electricExpanseType;
	}
	public void setElectricExpanseType(int electricExpanseType) {
		this.electricExpanseType = electricExpanseType;
	}
	public void setPropertyRentalPrice(double propertyRentalPrice) {
		this.propertyRentalPrice = propertyRentalPrice;
	}
	public ManageNavigation_FastCreateLandDTO(long landID, String landName,
			int orderCreationDate, double propertyRentalPrice, String address,
			String region,String postcode) {
		super();
		this.landID = landID;
		this.landName = landName;
		this.orderCreationDate = orderCreationDate;
		this.propertyRentalPrice = propertyRentalPrice;
		this.landAddress=address;
		this.landAddressRegion=region;
		this.landAddressPostcode=postcode;
	}
	
	
}
