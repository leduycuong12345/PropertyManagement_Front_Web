package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageDebt_PaginationDTO_ByLand {
	public int currentPage=0;
	public int totalPage=0;
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
	public ManageDebt_PaginationDTO_ByLand(int currentPage, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	
	
	
}
