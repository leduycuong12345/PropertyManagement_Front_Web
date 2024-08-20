package com.cuongsolution.manageproperty.front.web.Model;

public class Parameter {
	private long parameter_ID;
	private String parameter_Name;
	private String datatype;
	private String value;
	public long getParameter_ID() {
		return parameter_ID;
	}
	public void setParameter_ID(long parameter_ID) {
		this.parameter_ID = parameter_ID;
	}
	public String getParameter_Name() {
		return parameter_Name;
	}
	public void setParameter_Name(String parameter_Name) {
		this.parameter_Name = parameter_Name;
	}
	public String getDataType() {
		return datatype;
	}
	public void setDataType(String dataType) {
		this.datatype = dataType;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Parameter() {
		super();
	}
	
}
