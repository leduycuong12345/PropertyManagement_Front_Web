package com.cuongsolution.manageproperty.front.web.Controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_ExpanseHeaderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_OrderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_PaginationDTO_ByLand;
import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_PaginationDTO_ByWorksheet;
import com.cuongsolution.manageproperty.front.web.DTO.ManageDebt_Pagination_DebtListDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_EditLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ExpanseHeaderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ReceiptDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditFastRecurringExpanseListDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.OrderInfo.ManageDebt_OrderInfoService;
import com.cuongsolution.manageproperty.front.web.Service.Privileges.ManageDebt_PrivilegeService;
import com.cuongsolution.manageproperty.front.web.Service.Receipt.ManageDebt_ReceiptService;
import com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse.RecurringExpanseService;
import com.cuongsolution.manageproperty.front.web.Service.User.Oauth_UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageDebtController {
	private Logger logger = LoggerFactory.getLogger(ManageDebtController.class);
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private ManageDebt_OrderInfoService manageDebt_OrderInfoService;
	@Autowired
	private ManageDebt_ReceiptService manageDebt_ReceiptService;
	@Autowired
	private ManageDebt_PrivilegeService manageDebt_PrivilegeService;
	@Autowired
	private RecurringExpanseService recurringExpanseService;
	@Autowired
    private Oauth_UserService oauth_UserService;
	@GetMapping(value="/quan-ly-cong-no")
	public String manageDebtPageByLand( HttpSession session,Model model  ,Authentication authentication){
		
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {//oauth login
	        String oauthUsername=authentication.getName();
	        //return extracted_manageDebtPageByLand(session, model, oauthUsername);//this s cute, but the username in gmail may different with username_in_system
	        
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        return extracted_manageDebtPageByLand(session,model,realAppUsername  );
		} else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
	        return extracted_manageDebtPageByLand(session, model, username);
	    }
    }
	private String extracted_manageDebtPageByLand(HttpSession session, Model model, String username) {
		if(this.landService.getDetailsLandList_ManageNavigation_Production(username).isEmpty())//kiem tra xem ng dung da khoi tao Land chua? chua thi khoi tao
		{
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			return "new_user";
		}
		else
		{
			int totalRow=30;//we can make this edittable by admin later on
			int firstPage=0;
			//Pageable firstPageWithThirtyElements = PageRequest.of(firstPage, totalRow);
			
			UUID selectedLandID=(UUID) session.getAttribute("selectedLandID");
			if(selectedLandID !=null)//neu da chon land
			{
				List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				
				for(ManageNavigation_EditLandDTO land:landList)
				{
					if(land.getLandID()==selectedLandID)
					{
						model.addAttribute("selectedLandID",land.getLandID());//to create-property belong to land
						//model.addAttribute("selectedLandName",land.getLandName() );//to display selected-land-name at layout-sidebar
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
						
						Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(landList.get(0).getLandID()
								,firstPage,totalRow).getPageableObjectType();
						model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(firstPage,debtList.getTotalPages()));//for pagination function
						model.addAttribute("debtList",debtList);
						logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList);
						logger.info("2.agination debt of land id:"+selectedLandID +" with debt list:"+debtList.getContent());
						
						List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(selectedLandID);
						model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
					}
				}
				
			}
			else//neu chua chon land
			{
				List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);//for land list/delete/update func
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				
				Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(landList.get(0).getLandID()
						,firstPage,totalRow).getPageableObjectType();
				model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(firstPage,debtList.getTotalPages()));//for pagination function
				model.addAttribute("debtList",debtList );

				logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList);
				logger.info("2.agination debt of land id:"+selectedLandID +" with debt list:"+debtList.getContent());
				
				List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(landList.get(0).getLandID());
				model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
				
			}
			return "manage_debt_by_land";
		}
	}
	@PostMapping(value="/quan-ly-cong-no")
	public String manageDebtPageByLand_searchFunctionWithPageable( 
			//@RequestParam(value="selectedPage") Integer selectedPage, @RequestParam(value="totalPage") Integer totalPage,
			//@RequestParam(value="searchKeyword") String  searchKeyword
			@ModelAttribute ManageDebt_Pagination_DebtListDTO manageDebt_Pagination_DebtListDTO
			,HttpSession session,Model model  ,Authentication authentication){
		
			
			if (authentication instanceof OAuth2AuthenticationToken oauthToken) {//oauth login
		        String oauthUsername=authentication.getName();
		        //return extracted_manageDebtPageByLand_searchFunctionWithPageable(selectedPage, totalPage, searchKeyword,
				//		session, model, oauthUsername);//this s cute, but the username in gmail may different with username_in_system
		        
		        OAuth2User oauthUser = oauthToken.getPrincipal();
		        String email = oauthUser.getAttribute("email");
		        
		        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
		        		,oauthUsername,email);
		        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
		        return extracted_manageDebtPageByLand_searchFunctionWithPageable(manageDebt_Pagination_DebtListDTO,
		        		session, model,realAppUsername  );
		        
			} else {
		        // local/form login
		        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		        String username=userDetails.getUsername();
		        return extracted_manageDebtPageByLand_searchFunctionWithPageable(manageDebt_Pagination_DebtListDTO,
						session, model, username);
		    }
		
		
    }
	private String extracted_manageDebtPageByLand_searchFunctionWithPageable(ManageDebt_Pagination_DebtListDTO dto, HttpSession session, Model model, String username) {
		if(dto.getSelectedPage()<0)
		{
			dto.setSelectedPage(0);
		}
		if( (dto.getSelectedPage() >= dto.getTotalPage()-1 ) && (dto.getTotalPage()>0)  )
		{
			dto.setSelectedPage(dto.getTotalPage()-1);
		}
		if(this.landService.getDetailsLandList_ManageNavigation_Production(username).isEmpty())//kiem tra xem ng dung da khoi tao Land chua? chua thi khoi tao
		{
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			return "new_user";
		}
		else
		{
			logger.info("manageDebtPageByLand_searchFunctionWithPageable selectedPage:{},totalPage:{},searchKeyword:{}"
					,dto.getSelectedPage()
					,dto.getTotalPage()
					,dto.getSearchKey());
			int totalRow=30;//we can make this edittable by admin later on
			//check if currentPage is empty or not.If not pageable_function is working
			//int selectedPageResult = (dto.getSelectedPage() != null && !dto.getSelectedPage().equals("")) ? dto.setSelectedPage(0);
			
			//Pageable currentPageWithThirtyElements = PageRequest.of(selectedPageResult, totalRow);
			
			
			UUID selectedLandID=(UUID) session.getAttribute("selectedLandID");
			if(selectedLandID !=null)//neu da chon land
			{
				List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				
				for(ManageNavigation_EditLandDTO land:landList)
				{
					if(land.getLandID().equals(selectedLandID))
					{
						model.addAttribute("selectedLandID",land.getLandID());//to create-property belong to land
						//model.addAttribute("selectedLandName",land.getLandName() );//to display selected-land-name at layout-sidebar
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
						
						//check if searchKeyword is empty or not . If not empty search_function is working
						if(dto.getSearchKey() != null && !dto.getSearchKey().isEmpty())
						{

							Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_PageableAndSorting(land.getLandID()
									,dto.getSelectedPage(),totalRow,dto.getSearchKey());
							model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(dto.getSelectedPage(),debtList.getTotalPages()));//for pagination function
							model.addAttribute("debtList",debtList.toList() );

							logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.toList());
							logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.getContent());
							List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(selectedLandID);
							model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
						}
						else
						{

							Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(land.getLandID()
									,dto.getSelectedPage(),totalRow);
							model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(dto.getSelectedPage(),debtList.getTotalPages()));//for pagination function
							model.addAttribute("debtList",debtList.toList() );

							logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.toList());
							logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.getContent());
							
							List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(land.getLandID());
							model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
						}
					}
				}
				
			}
			else//neu chua chon land
			{
				List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);//for land list/delete/update func
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				
				//check if searchKeyword is empty or not . If not empty search_function is working
				if(dto.getSearchKey() != null && !dto.getSearchKey().isEmpty())
				{
					Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_PageableAndSorting(landList.get(0).getLandID()
							,dto.getSelectedPage(),totalRow,dto.getSearchKey());
					model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(dto.getSelectedPage(),debtList.getTotalPages()));//for pagination function
					model.addAttribute("debtList",debtList.toList() );

					logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.toList());
					logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.getContent());
					
					List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(landList.get(0).getLandID());
					model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
				}
				else
				{
					Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToLand_ManageDebt_Pageable(landList.get(0).getLandID()
							,dto.getSelectedPage(),totalRow);
					model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByLand(dto.getSelectedPage(),debtList.getTotalPages()));//for pagination function
					model.addAttribute("debtList",debtList.toList() );

					logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.toList());
					logger.info("pagination debt of land id:"+selectedLandID +" with debt list:"+debtList.getContent());
					
					List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(landList.get(0).getLandID());
					model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
				}
			}
			return "manage_debt_by_land";
		}
	}
	@PostMapping(value="/quan-ly-cong-no/hop-dong")
	public String manageDebt_BelongToWorksheet(HttpSession session, @RequestParam("worksheetId") UUID worksheetID,Model model  ,Authentication authentication){
		
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {//oauth login
	        String oauthUsername=authentication.getName();
	        //return extracted_manageDebt_BelongToWorksheet(worksheetID, model, oauthUsername);//this s cute, but the username in gmail may different with username_in_system
	        
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        return extracted_manageDebt_BelongToWorksheet(worksheetID,session,model,realAppUsername  );
		} else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
	        return extracted_manageDebt_BelongToWorksheet(worksheetID, session,model, username);
	    }
    }
	private String extracted_manageDebt_BelongToWorksheet(UUID worksheetID,HttpSession session, Model model, String username) {
		//kiem tra xem worksheet nay co thuoc pham vi nguoi dung hay khong 
		Boolean belongToUser=this.manageDebt_PrivilegeService.isWorksheetBelongToUser(worksheetID, username);
		if(belongToUser)
		{
			
			
			int totalRow=30;//we can make this edittable by admin later on
			int firstPage=0;
			//Pageable firstPageWithThirtyElements = PageRequest.of(firstPage, totalRow);
			
			UUID selectedLandID=(UUID) session.getAttribute("selectedLandID");
			if(selectedLandID !=null)//neu da chon land
			{
				List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				for(ManageNavigation_EditLandDTO land:landList)
				{
					if(land.getLandID()==selectedLandID)
					{
						
						model.addAttribute("selectedLandID",selectedLandID);//to create-property belong to land
						model.addAttribute("selectedLand",land);//to display selected-land-name at layout-sidebar
						
						Pageable firstPageWithThirtyElements = PageRequest.of(firstPage, totalRow);
						
						Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt(worksheetID,firstPageWithThirtyElements);
						model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByWorksheet(firstPage,debtList.getTotalPages(),worksheetID));//for pagination function
						model.addAttribute("debtList",debtList.getContent());

						logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.toList());
						logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.getContent());
						
						List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(landList.get(0).getLandID());
						model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
						model.addAttribute("worksheetID", worksheetID);//for pagination function
					}
				}
			}
			else
			{
				List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func

				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				
				Pageable firstPageWithThirtyElements = PageRequest.of(firstPage, totalRow);
				
				Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt(worksheetID,firstPageWithThirtyElements);
				model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByWorksheet(firstPage,debtList.getTotalPages(),worksheetID));//for pagination function
				model.addAttribute("debtList",debtList.getContent());

				logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.toList());
				logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.getContent());
				
				List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(landList.get(0).getLandID());
				model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
				model.addAttribute("worksheetID", worksheetID);//for pagination function
			}

			return "manage_debt_by_worksheet";
		}
		else
		{
			return "redirect:/quan-ly-cong-no";
		}
	}
	@PostMapping(value="/quan-ly-cong-no/hop-dong/pagination")
	public String manageDebt_BelongToWorksheet_pageable( @RequestParam("worksheetId") UUID worksheetID,
			@RequestParam("selectedPage") Integer selectedPage,
			@RequestParam("totalPage") Integer totalPage
			,@RequestParam("searchKey") String searchKey,Model model  ,Authentication authentication,HttpSession session){
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {//oauth login
	        String oauthUsername=authentication.getName();
			//return extracted_manageDebt_BelongToWorksheet_pageable(worksheetID, selectedPage, totalPage, model, oauthUsername);//this s cute, but the username in gmail may different with username_in_system
	        
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        return extracted_manageDebt_BelongToWorksheet_pageable(worksheetID,searchKey, session,selectedPage,totalPage,model,realAppUsername  );
		
		} else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
			return extracted_manageDebt_BelongToWorksheet_pageable(worksheetID,searchKey,session, selectedPage, totalPage, model, username);
	    }
    }
	private String extracted_manageDebt_BelongToWorksheet_pageable(UUID worksheetID,String searchKeyword, HttpSession session, Integer selectedPage,
			Integer totalPage, Model model,String username) {
		if(selectedPage<0)
		{
			selectedPage=0;
		}
		if ( (selectedPage>=totalPage-1 ) && (totalPage>0))
		{
			selectedPage=totalPage-1;
		}
		//kiem tra xem worksheet nay co thuoc pham vi nguoi dung hay khong 
		Boolean belongToUser=this.manageDebt_PrivilegeService.isWorksheetBelongToUser(worksheetID, username);
		if(belongToUser)
		{
			List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);//for land list/delete/update func
			model.addAttribute("landList",landList);//for land list/delete/update func
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			
			UUID selectedLandID=(UUID) session.getAttribute("selectedLandID");
			if(selectedLandID !=null)//neu da chon land
			{
				for(ManageNavigation_EditLandDTO land:landList)
				{
					if(land.getLandID().equals(selectedLandID))
					{
						model.addAttribute("selectedLandID",selectedLandID);//to create-property belong to land
						model.addAttribute("selectedLand",land);//to display selected-land-name at layout-sidebar
						
						//int totalRow=30;//we can make this edittable by admin later on
						//int selectedPageResult=(selectedPage != null && !selectedPage.equals("")) ? selectedPage : 0;
						//Pageable selectedPageWithThirtyElements = PageRequest.of(selectedPageResult, totalRow);
						
						//Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt(worksheetID,selectedPageWithThirtyElements);
						Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt_paginationAndSorting(worksheetID,selectedLandID, selectedPage,totalPage ,searchKeyword);
						
						model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByWorksheet(selectedPage,debtList.getTotalPages(),worksheetID));//for pagination function
						model.addAttribute("debtList",debtList.toList());

						logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.toList());
						logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.getContent());
						
						List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(landList.get(0).getLandID());
						model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
						model.addAttribute("worksheetID", worksheetID);//for pagination function
					}
				}
			}
			else
			{
				UUID firstLandID=landList.get(0).getLandID();
				model.addAttribute("selectedLandID",firstLandID);//to create-property belong to land
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				
				int selectedPageResult=(selectedPage != null && !selectedPage.equals("")) ? selectedPage : 0;
				
				
				//Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt(worksheetID,selectedPageWithThirtyElements);
				Page<ManageDebt_OrderDTO> debtList=this.manageDebt_OrderInfoService.getDebtList_BelongToWorksheet_ManageDebt_paginationAndSorting(worksheetID,firstLandID, selectedPage,totalPage ,searchKeyword);
				
				model.addAttribute("pagination",new ManageDebt_PaginationDTO_ByWorksheet(selectedPageResult,debtList.getTotalPages(),worksheetID));//for pagination function
				model.addAttribute("debtList",debtList.toList());

				logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.toList());
				logger.info("pagination debt of worksheet id:"+worksheetID +" with debt list:"+debtList.getContent());
				
				List<ManageDebt_ExpanseHeaderDTO> expanseHeaderList=this.recurringExpanseService.manageDebt_findRecurringExpanseBelongToLand(landList.get(0).getLandID());
				model.addAttribute("expanseHeaderList", expanseHeaderList);//for order-list function
				model.addAttribute("worksheetID", worksheetID);//for pagination function
			}
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
	public String deleteOrder_ManageDebt( @RequestParam("orderID") UUID orderID) throws Exception {
    	this.manageDebt_OrderInfoService.deleteOrder_ManageDebt(orderID);
		return "redirect:/quan-ly-cong-no";
    }
	@PostMapping(value="/quan-ly-cong-no/xoa-hoan-toan-hoa-don")
	public String hardDeleteOrder_ManageDebt( @RequestParam("orderID") UUID orderID) throws Exception {
		this.manageDebt_OrderInfoService.hardDeleteOrder_ManageDebt(orderID);
		return "redirect:/quan-ly-cong-no";
    }
}
