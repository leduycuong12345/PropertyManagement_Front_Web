package com.cuongsolution.manageproperty.front.web.Controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_EditLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.User.Oauth_UserService;

import jakarta.servlet.http.HttpSession;
@Controller
public class ManageNagivationController {
	private Logger logger = LoggerFactory.getLogger(ManageNagivationController.class);
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
    private Oauth_UserService oauth_UserService;
	
	@PostMapping(value="/land/create")
	//public String postCreateLandPage( @ModelAttribute("newLand") ManageNavigation_FastCreateLandDTO newLand,Model model,Principal principal)  {
	public String postCreateLandPage( @ModelAttribute("newLand") ManageNavigation_FastCreateLandDTO newLand
			,Model model,Authentication authentication)  
	{		
		//logger.info(" ManageNagivationController  postCreateLandPage Received request post to create land with land-name:{}",newLand.getNewLandName());
		//this.landService.createLand_ManageNavigation_Production(newLand,principal.getName());
		//return "redirect:/quan-ly";
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {
			//oauth login
	        String oauthUsername=authentication.getName();
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("ManageNagivationController  postCreateLandPage user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        this.landService.createLand_ManageNavigation_Production(newLand,realAppUsername);
			return "redirect:/quan-ly";
	    } else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
	        this.landService.createLand_ManageNavigation_Production(newLand,username);
			return "redirect:/quan-ly";
	    }
    }
	@PostMapping(value="/land/edit")
	public String postEditLand( @RequestParam("landID") UUID landID
			,@RequestParam("landName") String landName
			,@RequestParam("propertyRentalPrice") double propertyRentalPrice
			,@RequestParam("orderCreationDate") int orderCreationDate
			,@RequestParam("landAddress") String landAddress
			,@RequestParam("landAddressPostcode") String landAddressPostcode
			,Model model,Authentication authentication)  {
		
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {
			//oauth login
	        String oauthUsername=authentication.getName();
	       // return extractedPostEditLand(landID, landName, propertyRentalPrice, orderCreationDate, landAddress,
		//			landAddressPostcode, oauthUsername);//this s cute, but the username in gmail may different with username_in_system
	        
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        return extractedPostEditLand(landID, landName, propertyRentalPrice, orderCreationDate, landAddress,
	        				landAddressPostcode,realAppUsername  );
	    } else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
	        return extractedPostEditLand(landID, landName, propertyRentalPrice, orderCreationDate, landAddress,
					landAddressPostcode, username);
	    }
    }
	private String extractedPostEditLand(UUID landID, String landName, double propertyRentalPrice,
			int orderCreationDate, String landAddress, String landAddressPostcode, String username) {
		ManageNavigation_EditLandDTO editLand=new ManageNavigation_EditLandDTO(landID,landName,propertyRentalPrice,orderCreationDate,landAddress,landAddressPostcode);
		this.landService.editLand_ManageNavigation_Production(editLand,username);
		//return "redirect:/land/list";
		return "redirect:/quan-ly";
	}
	@PostMapping(value="/land/delete")
	public String deleteLand( Model model,@RequestParam(value = "landID") UUID landID,Authentication authentication,HttpSession session)  {
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {
			//oauth login
	        String oauthUsername=authentication.getName();
	        //return extractedDeleteLand(landID, oauthUsername, session);//this s cute, but the username in gmail may different with username_in_system
	        
	        OAuth2User oauthUser = oauthToken.getPrincipal();
	        String email = oauthUser.getAttribute("email");
	        
	        logger.info("user access manageproperty by google_oauth gmail account with username:{},email:{}"
	        		,oauthUsername,email);
	        String realAppUsername=this.oauth_UserService.getRealUsernameByGmail_OAuth2(email);
	        return extractedDeleteLand(landID, realAppUsername, session  );
	    } else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
	        return extractedDeleteLand(landID, username, session);
	    }
    }
	private String extractedDeleteLand(UUID landID, String username, HttpSession session) {
		this.landService.deleteLand_ManageNavigation_Production(landID,username);
		//return "redirect:/land/list";
		session.removeAttribute("selectedLandID");//if land is selected but user_deleted ll cause error because "selectedLandID" after removed cant retrieve from db anymore
		return "redirect:/quan-ly";
	}
}
