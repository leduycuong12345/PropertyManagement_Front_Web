package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageProperty_RecurringExpanseDTO {
	private long propertyServiceID;
	private String recurringExpanseName;
	private float recurringExpansePrice;	
	private ManageProperty_ReadingDTO lastRecord; 
	private String recurringExpanseUnitCount;
	private int recurringExpanseType;
	private boolean enabled=true;
	
	
	public long getPropertyServiceID() {
		return propertyServiceID;
	}
	public void setPropertyServiceID(long propertyServiceID) {
		this.propertyServiceID = propertyServiceID;
	}
	public int getRecurringExpanseType() {
		return recurringExpanseType;
	}
	public void setRecurringExpanseType(int recurringExpanseType) {
		this.recurringExpanseType = recurringExpanseType;
	}
	public String getRecurringExpanseName() {
		return recurringExpanseName;
	}
	public void setRecurringExpanseName(String recurringExpanseName) {
		this.recurringExpanseName = recurringExpanseName;
	}
	public float getRecurringExpansePrice() {
		return recurringExpansePrice;
	}
	public void setRecurringExpansePrice(float recurringExpansePrice) {
		this.recurringExpansePrice = recurringExpansePrice;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public ManageProperty_ReadingDTO getLastRecord() {
		return lastRecord;
	}
	public void setLastRecord(ManageProperty_ReadingDTO lastRecord) {
		this.lastRecord = lastRecord;
	}
	
	public String getRecurringExpanseUnitCount() {
		return recurringExpanseUnitCount;
	}
	public void setRecurringExpanseUnitCount(String recurringExpanseUnitCount) {
		this.recurringExpanseUnitCount = recurringExpanseUnitCount;
	}
	public ManageProperty_RecurringExpanseDTO() {
		super();
	}
	// luồng sequences create-worksheet: dành cho chức năng tính theo-số-ghi-đồng-hồ (số trước và số sau )
	//luồng sequences create-worksheet dành cho chức năng tính theo đầu người hoặc theo tổng-dùng
	public ManageProperty_RecurringExpanseDTO(long propertyServiceID, String recurringName,
			float recurringExpansePrice, String recurringExpanseUnitCount
			,int recurringExpanseType) {
		super();
		this.propertyServiceID = propertyServiceID;
		this.recurringExpanseName = recurringName;
		this.recurringExpansePrice = recurringExpansePrice;
		this.lastRecord = new ManageProperty_ReadingDTO ();
		this.recurringExpanseUnitCount = recurringExpanseUnitCount;
		this.enabled = true;
		this.recurringExpanseType= recurringExpanseType;
	}
	public ManageProperty_RecurringExpanseDTO(long propertyServiceID, String recurringName,
			float recurringExpansePrice,ManageProperty_ReadingDTO lastRecord,String recurringExpanseUnitCount
			,int recurringExpanseType) {
		super();
		this.propertyServiceID = propertyServiceID;
		this.recurringExpanseName = recurringName;
		this.recurringExpansePrice = recurringExpansePrice;
		this.lastRecord = lastRecord;
		this.recurringExpanseUnitCount = recurringExpanseUnitCount;
		this.enabled = true;
		this.recurringExpanseType= recurringExpanseType;
	}
}
