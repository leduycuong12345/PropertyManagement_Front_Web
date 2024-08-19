package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageDebt_PaginationDTO_ByWorksheet {
	public int currentPage=0;
	public int totalPage=0;
	public long worksheetId;
	
	
	public long getWorksheetId() {
		return worksheetId;
	}
	public void setWorksheetId(long worksheetId) {
		this.worksheetId = worksheetId;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public ManageDebt_PaginationDTO_ByWorksheet(int currentPage, int totalPage, long worksheetId) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.worksheetId = worksheetId;
	}
	
	
	
}
