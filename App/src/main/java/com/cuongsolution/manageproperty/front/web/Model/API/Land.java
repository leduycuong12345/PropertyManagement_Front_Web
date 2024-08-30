package com.cuongsolution.manageproperty.front.web.Model.API;
import java.util.ArrayList;
import java.util.List;



public class Land {
	private long Land_ID;
	private String Land_Name;
	private double Rental_Property_Price;

	private List<Property> propertyList = new ArrayList<>();

	private List<RecurringExpanse> recurringExpanseList = new ArrayList<>();

	private List<Privilege> privilegeList = new ArrayList<>();
	private int order_Creation_Date;
	private boolean land_Is_Delete=false;
	
	private String address;
	private String addressRegion;
	private String addressPostcode;
	private String countryCode;
	private Double gPS_Lat;
	private Double gPS_Lng;
	
	public int getOrder_Creation_Date() {
		return order_Creation_Date;
	}
	public void setOrder_Creation_Date(int order_Creation_Date) {
		this.order_Creation_Date = order_Creation_Date;
	}
	public long getLand_ID() {
		return Land_ID;
	}
	public void setLand_ID(long land_ID) {
		this.Land_ID = land_ID;
	}
	public String getLand_Name() {
		return Land_Name;
	}
	public void setLand_Name(String land_Name) {
		this.Land_Name = land_Name;
	}
	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}
	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
	}
	public Land() {
		super();
	}
	
	public double getRental_Property_Price() {
		return Rental_Property_Price;
	}
	public void setRental_Property_Price(double rental_Property_Price) {
		Rental_Property_Price = rental_Property_Price;
	}
	public List<Property> getPropertyList() {
		return propertyList;
	}
	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
	
	
	public List<RecurringExpanse> getRecurringExpanseList() {
		return recurringExpanseList;
	}
	public void setRecurringExpanseList(List<RecurringExpanse> recurringExpanseList) {
		this.recurringExpanseList = recurringExpanseList;
	}
	public boolean isLand_Is_Delete() {
		return land_Is_Delete;
	}
	public void setLand_Is_Delete(boolean land_Is_Delete) {
		this.land_Is_Delete = land_Is_Delete;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressRegion() {
		return addressRegion;
	}
	public void setAddressRegion(String addressRegion) {
		this.addressRegion = addressRegion;
	}
	public String getAddressPostcode() {
		return addressPostcode;
	}
	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getgPS_Lat() {
		return gPS_Lat;
	}
	public void setgPS_Lat(double gPS_Lat) {
		this.gPS_Lat = gPS_Lat;
	}
	public double getgPS_Lng() {
		return gPS_Lng;
	}
	public void setgPS_Lng(double gPS_Lng) {
		this.gPS_Lng = gPS_Lng;
	}
	public Land(String land_Name, int order_Creation_Date,double Rental_Property_Price,double lat,double lng,String address,String addressRegion, String addressPostcode,String countryCode) {
		super();
		this.Land_Name = land_Name;
		this.order_Creation_Date = order_Creation_Date;
		this.Rental_Property_Price=Rental_Property_Price;
		this.gPS_Lat=lat;
		this.gPS_Lng=lng;
		this.address=address;
		this.addressRegion=addressRegion;
		this.addressPostcode=addressPostcode;
		this.countryCode=countryCode;
	}
	
	
}
