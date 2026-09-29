package com.cuongsolution.manageproperty.front.web.Controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_CreateRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_EditRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_EditLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.Property.ManageProperty_PropertySer;
import com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse.RecurringExpanseService;
import com.cuongsolution.manageproperty.front.web.Service.RecurringExpanseUnit.RecurringExpanseUnitService;
import com.cuongsolution.manageproperty.front.web.Service.User.Oauth_UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageExpanseController {
	private Logger logger = LoggerFactory.getLogger(ManageExpanseController.class);
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private RecurringExpanseService recurringExpanseService;
	@Autowired
	private RecurringExpanseUnitService recurringExpanseUnitService;
	@Autowired
	private ManageProperty_PropertySer propertyService;
	@Autowired
    private Oauth_UserService oauth_UserService;
	@GetMapping(value="/quan-ly-dich-vu")
	public String manageExpansePage( HttpSession session,Model model,Authentication authentication)  {
		
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {//oauth login
	        String oauthUsername=authentication.getName();
			//return extracted_manageExpansePage(session, model, oauthUsername);//this s cute, but the username in gmail may different with username_in_system
	        
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        return extracted_manageExpansePage(session,model,realAppUsername  );
		
		} else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
			return extracted_manageExpansePage(session, model, username);
	    }
    }
	private String extracted_manageExpansePage(HttpSession session, Model model, String username) {
		if(this.landService.getDetailsLandList_ManageNavigation_Production(username).isEmpty())//kiem tra xem ng dung da khoi tao Land chua? chua thi khoi tao
		{
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			return "new_user";
		}
		else
		{
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
						model.addAttribute("recurringExpanseList", this.recurringExpanseService.manageExpanse_findRecurringExpanseBelongToLand(land.getLandID()));//recurring expanse list
						model.addAttribute("recurringExpanseUnitList",this.recurringExpanseUnitService.findAll_ManageExpanse());//for edit-expanse function
						model.addAttribute("editRecurringExpanse",new ManageExpanse_EditRecurringExpanseDTO());//for edit-expanse function
						model.addAttribute("propertyList", this.propertyService.manageExpanse_createExpanse_getPropertyListBelongToLand(landList.get(0).getLandID()));//for create-expanse function
						model.addAttribute("newExpanse",new ManageExpanse_CreateRecurringExpanseDTO());//for create-expanse function
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
				

				model.addAttribute("recurringExpanseList", this.recurringExpanseService.manageExpanse_findRecurringExpanseBelongToLand(landList.get(0).getLandID()));//recurring expanse list
				model.addAttribute("recurringExpanseUnitList",this.recurringExpanseUnitService.findAll_ManageExpanse());//for edit-expanse function
				model.addAttribute("editRecurringExpanse",new ManageExpanse_EditRecurringExpanseDTO());//for edit-expanse function
				model.addAttribute("propertyList", this.propertyService.manageExpanse_createExpanse_getPropertyListBelongToLand(landList.get(0).getLandID()));//for create-expanse function
				model.addAttribute("newExpanse",new ManageExpanse_CreateRecurringExpanseDTO());//for create-expanse function
			}
			return "manage_expanse";
		}
	}
	@PostMapping("/quan-ly-dich-vu/xoa-dich-vu")
	public String deleteRecurringExpanse(@RequestParam(value = "recurringExpanseID") UUID recurringExpanseID) {
	  	this.recurringExpanseService.manageExpanse_deleteByID(recurringExpanseID);
		return "redirect:/quan-ly-dich-vu";
	}
	@PostMapping("/quan-ly-dich-vu/chinh-sua-dich-vu")
	public String editRecurringExpanse(
			@ModelAttribute(value = "editRecurringExpanse") ManageExpanse_EditRecurringExpanseDTO editRecurringExpanse) {
		//System.out.println("select expanse id list:"+selectedPropertyServiceIDList);
		this.recurringExpanseService.manageExpanse_editExpanseDTO(editRecurringExpanse);
		return "redirect:/quan-ly-dich-vu";
	}
	@PostMapping("/quan-ly-dich-vu/them-dich-vu")
	public String createRecurringExpanse(
			@ModelAttribute(value = "newExpanse") ManageExpanse_CreateRecurringExpanseDTO newExpanseDTO) {
		//System.out.println("select expanse id list:"+selectedPropertyServiceIDList);
		this.recurringExpanseService.manageExpanse_createRecurringExpanse(newExpanseDTO);
		return "redirect:/quan-ly-dich-vu";
	}

}
