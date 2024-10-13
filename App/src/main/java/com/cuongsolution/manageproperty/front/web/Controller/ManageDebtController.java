package com.cuongsolution.manageproperty.front.web.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_OrderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_PaginationDTO_ByLand;
import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_PaginationDTO_ByWorksheet;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ReceiptDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.OrderInfo.ManageDebt_OrderInfoService;
import com.cuongsolution.manageproperty.front.web.Service.Privileges.ManageDebt_PrivilegeService;
import com.cuongsolution.manageproperty.front.web.Service.Receipt.ManageDebt_ReceiptService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageDebtController {
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private ManageDebt_OrderInfoService manageDebt_OrderInfoService;
	@Autowired
	private ManageDebt_ReceiptService manageDebt_ReceiptService;
	@Autowired
	private ManageDebt_PrivilegeService manageDebt_PrivilegeService;
	@GetMapping(value="/quan-ly-cong-no")
	public String manageDebtPageByLand( HttpSession session,Model model  ,Principal principal){
		if(this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName()).isEmpty())//kiem tra xem ng dung da khoi tao Land chua? chua thi khoi tao
		{
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			return "new_user";
		}
		else
		{
			int totalRow=30;//we can make this edittable by admin later on
			int firstPage=0;
			//Pageable firstPageWithThirtyElements = PageRequest.of(firstPage, totalRow);
			
			Long selectedLandID=(Long) session.getAttribute("selectedLandID");
			if(selectedLandID !=null)//neu da chon land
			{
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				
				for(ManageNavigation_FastCreateLandDTO land:landList)
				{
					if(land.getLandID()==selectedLandID)
					{
						model.addAttribute("selectedLandID",land.getLandID());//to create-property belong to land
						//model.addAttribute("selectedLandName",land.getLandName() );//to display selected-land-name at layout-sidebar
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
						
						Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(land.getLandID()
								,firstPage,totalRow);
						model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(firstPage,debtList.getTotalPages()));//for pagination function
						model.addAttribute("debtList",debtList );
					}
				}
				
			}
			else//neu chua chon land
			{
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				
				Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(landList.get(0).getLandID()
						,firstPage,totalRow);
				model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(firstPage,debtList.getTotalPages()));//for pagination function
				model.addAttribute("debtList",debtList );
			}
			return "manage_debt_by_land";
		}
		
    }

	
	@PostMapping(value="/quan-ly-cong-no")
	public String manageDebtPageByLand_searchFunctionWithPageable( @RequestParam("selectedPage") Integer selectedPage, @RequestParam("totalPage") Integer totalPage,@RequestParam("searchKeyword") String  searchKeyword
			,HttpSession session,Model model  ,Principal principal){
		
		if(selectedPage<0)
		{
			selectedPage=0;
		}
		if(selectedPage>=totalPage-1 )
		{
			selectedPage=totalPage-1;
		}
		if(this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName()).isEmpty())//kiem tra xem ng dung da khoi tao Land chua? chua thi khoi tao
		{
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			return "new_user";
		}
		else
		{
			int totalRow=30;//we can make this edittable by admin later on
			//check if currentPage is empty or not.If not pageable_function is working
			int selectedPageResult = (selectedPage != null && !selectedPage.equals("")) ? selectedPage : 0;
			//Pageable currentPageWithThirtyElements = PageRequest.of(selectedPageResult, totalRow);
			
			
			Long selectedLandID=(Long) session.getAttribute("selectedLandID");
			if(selectedLandID !=null)//neu da chon land
			{
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				
				for(ManageNavigation_FastCreateLandDTO land:landList)
				{
					if(land.getLandID()==selectedLandID)
					{
						model.addAttribute("selectedLandID",land.getLandID());//to create-property belong to land
						//model.addAttribute("selectedLandName",land.getLandName() );//to display selected-land-name at layout-sidebar
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
						
						//check if searchKeyword is empty or not . If not empty search_function is working
						if(searchKeyword != null && !searchKeyword.isEmpty())
						{

							Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_PageableAndSorting(land.getLandID()
									,selectedPageResult,totalRow,searchKeyword);
							model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(selectedPageResult,debtList.getTotalPages()));//for pagination function
							model.addAttribute("debtList",debtList );
						}
						else
						{

							Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(land.getLandID()
									,selectedPageResult,totalRow);
							model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(selectedPageResult,debtList.getTotalPages()));//for pagination function
							model.addAttribute("debtList",debtList );
						}
					}
				}
				
			}
			else//neu chua chon land
			{
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				
				//check if searchKeyword is empty or not . If not empty search_function is working
				if(searchKeyword != null && !searchKeyword.isEmpty())
				{
					Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_PageableAndSorting(landList.get(0).getLandID()
							,selectedPageResult,totalRow,searchKeyword);
					model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(selectedPageResult,debtList.getTotalPages()));//for pagination function
					model.addAttribute("debtList",debtList );
				}
				else
				{
					Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(landList.get(0).getLandID()
							,selectedPageResult,totalRow);
					model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(selectedPageResult,debtList.getTotalPages()));//for pagination function
					model.addAttribute("debtList",debtList );
				}
			}
			return "manage_debt_by_land";
		}
		
    }
	@GetMapping(value="/quan-ly-cong-no/hop-dong")
	public String manageDebt_BelongToWorksheet( @RequestParam("worksheetId") Long worksheetID,Model model  ,Principal principal){
		//kiem tra xem worksheet nay co thuoc pham vi nguoi dung hay khong 
		Boolean belongToUser=this.manageDebt_PrivilegeService.isWorksheetBelongToUser(worksheetID, principal.getName());
		if(belongToUser)
			
		{
			List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
			model.addAttribute("landList",landList);//for land list/delete/update func
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
			model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
			
			int totalRow=30;//we can make this edittable by admin later on
			int firstPage=0;
			Pageable firstPageWithThirtyElements = PageRequest.of(firstPage, totalRow);
			
			Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt(worksheetID,firstPageWithThirtyElements);
			model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByWorksheet(firstPage,debtList.getTotalPages(),worksheetID));//for pagination function
			model.addAttribute("debtList",debtList.toList());
			return "manage_debt_by_worksheet";
			
		}
		else
		{
			return "redirect:/quan-ly-cong-no";
		}
    }
	@PostMapping(value="/quan-ly-cong-no/hop-dong")
	public String manageDebt_BelongToWorksheet_pageable( @RequestParam("worksheetId") Long worksheetID,@RequestParam("selectedPage") Integer selectedPage,
			@RequestParam("totalPage") Integer totalPage,Model model  ,Principal principal){
		
		if(selectedPage<0)
		{
			selectedPage=0;
		}
		if(selectedPage>=totalPage-1 )
		{
			selectedPage=totalPage-1;
		}
		//kiem tra xem worksheet nay co thuoc pham vi nguoi dung hay khong 
		Boolean belongToUser=this.manageDebt_PrivilegeService.isWorksheetBelongToUser(worksheetID, principal.getName());
		if(belongToUser)
			
		{
			List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
			model.addAttribute("landList",landList);//for land list/delete/update func
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
			model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
			
			int totalRow=30;//we can make this edittable by admin later on
			int selectedPageResult=(selectedPage != null && !selectedPage.equals("")) ? selectedPage : 0;
			Pageable selectedPageWithThirtyElements = PageRequest.of(selectedPageResult, totalRow);
			
			Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt(worksheetID,selectedPageWithThirtyElements);
			model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByWorksheet(selectedPageResult,debtList.getTotalPages(),worksheetID));//for pagination function
			model.addAttribute("debtList",debtList.toList());
			return "manage_debt_by_worksheet";
			
		}
		else
		{
			return "redirect:/quan-ly-cong-no";
		}
    }
    @PostMapping(value="/quan-ly-cong-no/thanh-toan")
    public String createPayment_ManageDebt( @ModelAttribute("newReceipt")  ManageOrder_ReceiptDTO newReceipt) throws Exception {
    	this.manageDebt_ReceiptService.createReceipt_ManageDebt(newReceipt);
		return "redirect:/quan-ly-cong-no";
    }
    @PostMapping(value="/quan-ly-cong-no/xoa-hoa-don")
	public String deleteOrder_ManageDebt( @RequestParam("orderID") Long orderID) throws Exception {
    	this.manageDebt_OrderInfoService.deleteOrder_ManageDebt(orderID);
		return "redirect:/quan-ly-cong-no";
    }
	@PostMapping(value="/quan-ly-cong-no/xoa-hoan-toan-hoa-don")
	public String hardDeleteOrder_ManageDebt( @RequestParam("orderID") Long orderID) throws Exception {
		this.manageDebt_OrderInfoService.hardDeleteOrder_ManageDebt(orderID);
		return "redirect:/quan-ly-cong-no";
    }
}
