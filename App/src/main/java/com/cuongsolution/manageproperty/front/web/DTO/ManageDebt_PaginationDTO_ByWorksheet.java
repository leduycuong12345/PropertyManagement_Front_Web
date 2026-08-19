package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.UUID;

public class ManageDebt_PaginationDTO_ByWorksheet {
	public int currentPage=0;
	public int totalPage=0;
	public UUID worksheetId;
	
	
	public UUID getWorksheetId() {
		return worksheetId;
	}
	public void setWorksheetId(UUID worksheetId) {
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
	public ManageDebt_PaginationDTO_ByWorksheet(int currentPage, int totalPage, UUID worksheetId) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.worksheetId = worksheetId;
	}
	
	
	
}
