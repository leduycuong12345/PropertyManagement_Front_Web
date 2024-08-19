package com.cuongsolution.manageproperty.front.web.DTO;



public class ManageProperty_EditPropertyDTO {
	private long propertyID;
	private String propertyName;
	private double propertyRentalPrice;
	private int worksheetTimeInverval;
	private double worksheetTotalDeposit;
	private int worksheetOrderCreationDate;

	public int getWorksheetOrderCreationDate() {
		return worksheetOrderCreationDate;
	}



	public void setWorksheetOrderCreationDate(int worksheetOrderCreationDate) {
		this.worksheetOrderCreationDate = worksheetOrderCreationDate;
	}


	public int getWorksheetTimeInverval() {
		return worksheetTimeInverval;
	}



	public void setWorksheetTimeInverval(int worksheetTimeInverval) {
		this.worksheetTimeInverval = worksheetTimeInverval;
	}



	public double getWorksheetTotalDeposit() {
		return worksheetTotalDeposit;
	}



	public void setWorksheetTotalDeposit(double worksheetTotalDeposit) {
		this.worksheetTotalDeposit = worksheetTotalDeposit;
	}





	public ManageProperty_EditPropertyDTO(long propertyID, String propertyName) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
	}



	public ManageProperty_EditPropertyDTO(long propertyID, String propertyName, double propertyRentalPrice) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
		this.propertyRentalPrice = propertyRentalPrice;
	}


	public ManageProperty_EditPropertyDTO() {
		super();
	}




	



	public double getPropertyRentalPrice() {
		return propertyRentalPrice;
	}


	public void setPropertyRentalPrice(double propertyRentalPrice) {
		this.propertyRentalPrice = propertyRentalPrice;
	}


	public long getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(long propertyID) {
		this.propertyID = propertyID;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}



	public ManageProperty_EditPropertyDTO(long propertyID, String propertyName,  double propertyRentalPrice,
			 double worksheetTotalDeposit, int worksheetOrderCreationDate,int worksheettimeInverval) {
		super();
		this.propertyID = propertyID;
		this.propertyName = propertyName;
		this.propertyRentalPrice = propertyRentalPrice;
		this.worksheetTimeInverval = worksheettimeInverval;
		this.worksheetTotalDeposit = worksheetTotalDeposit;
		this.worksheetOrderCreationDate = worksheetOrderCreationDate;
	}


}
