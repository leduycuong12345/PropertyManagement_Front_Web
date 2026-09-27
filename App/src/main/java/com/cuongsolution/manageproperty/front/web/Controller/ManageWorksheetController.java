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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_EditLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.User.Oauth_UserService;
import com.cuongsolution.manageproperty.front.web.Service.Worksheet.WorksheetService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageWorksheetController {

	private Logger logger = LoggerFactory.getLogger(ManageWorksheetController.class);
	@Autowired
	private WorksheetService worksheetService;
	@Autowired
	private ManageNavigation_LandService_Production landService;
    @Autowired
    private Oauth_UserService oauth_UserService;
	@GetMapping(value="/quan-ly-hop-dong")
	public String getWorksheetList(HttpSession session, Model model,Authentication authentication) throws Exception {
		
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {//oauth login
	        String oauthUsername=authentication.getName();
			//return extracted_getWorksheetList(session, model, oauthUsername);//this s cute, but the username in gmail may different with username_in_system
	        
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        return extracted_getWorksheetList(session, model, realAppUsername);
		} else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
			return extracted_getWorksheetList(session, model, username);
	    }
    }
	private String extracted_getWorksheetList(HttpSession session, Model model, String username) {
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
						model.addAttribute("selectedLand",land);//to display selected-land-name at layout-sidebar
						model.addAttribute("worksheetList", this.worksheetService.findAllBelongToLandID(selectedLandID));//for worksheet-list function
					}
				}
			}
			else//neu chua chon land
			{
				List<ManageNavigation_EditLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(username);//for land list/delete/update func
				model.addAttribute("landList",landList);//for land list/delete/update func
				model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
				model.addAttribute("selectedLandID",landList.get(0).getLandID());//to create-property belong to land
				//model.addAttribute("selectedLandName",landList.get(0).getLandName() );//to display selected-land-name at layout-sidebar
				model.addAttribute("selectedLand",landList.get(0));//to display selected-land-name at layout-sidebar
				model.addAttribute("worksheetList", this.worksheetService.findAllBelongToLandID(landList.get(0).getLandID()));//for worksheet-list function
			}
		}

		return "manage_worksheet";
	}
    @PostMapping("/quan-ly/xoa-hop-dong")
    public String deleteWorksheet(@RequestParam("worksheetID") UUID worksheetID) {
		//System.out.println(property);
    	this.worksheetService.deleteWorksheet(worksheetID);
    	//System.out.println(result);
    	return "redirect:/quan-ly";
    }
}

