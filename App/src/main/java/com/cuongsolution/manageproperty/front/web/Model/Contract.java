package com.cuongsolution.manageproperty.front.web.Model;


public class Contract {
	private long contractID;
	private boolean isDeligated=false;
	private boolean contractIsDelete=false;
	
	private Tenant tenant;
	
	private Worksheet worksheet;
	
	
	public boolean isDeligated() {
		return isDeligated;
	}
	public void setDeligated(boolean isDeligated) {
		this.isDeligated = isDeligated;
	}
	public boolean isContractIsDelete() {
		return contractIsDelete;
	}
	public void setContractIsDelete(boolean ContractIsDelete) {
		contractIsDelete = ContractIsDelete;
	}
	public long getContractID() {
		return contractID;
	}
	public void setContractID(long ContractID) {
		contractID = ContractID;
	}
	public Contract()
	{
		this.contractIsDelete=false;
	}
	
	public Contract(Worksheet worksheet, Tenant tenant) {
		super();
		this.tenant = tenant;
		this.worksheet = worksheet;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public Worksheet getWorksheet() {
		return worksheet;
	}
	public void setWorksheet(Worksheet worksheet) {
		this.worksheet = worksheet;
	}
	public Contract(Tenant tenant, Worksheet worksheet,boolean isDeligated) {
		super();
		this.tenant = tenant;
		this.worksheet = worksheet;
		this.isDeligated=isDeligated;
	}
}
