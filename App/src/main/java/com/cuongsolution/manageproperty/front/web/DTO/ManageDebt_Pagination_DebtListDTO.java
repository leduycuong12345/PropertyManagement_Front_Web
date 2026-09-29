package com.cuongsolution.manageproperty.front.web.DTO;

public class ManageDebt_Pagination_DebtListDTO {
	private Integer selectedPage=0; 
	private Integer totalPage=0;
	private String  searchKey="";
	public Integer getSelectedPage() {
		return selectedPage;
	}
	public void setSelectedPage(Integer selectedPage) {
		this.selectedPage = selectedPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public String getSearchKey() {
		return searchKey;
	}
	public ManageDebt_Pagination_DebtListDTO(Integer selectedPage, Integer totalPage, String searchKey) {
		super();
		this.selectedPage = selectedPage;
		this.totalPage = totalPage;
		this.searchKey = searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public ManageDebt_Pagination_DebtListDTO() {
		super();
	}
	
	
}
