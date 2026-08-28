package com.cuongsolution.manageproperty.front.web.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_EditLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.Service.Chart.ManageCharts_ChartService;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;

import jakarta.servlet.http.HttpSession;


@Controller
public class ManageChartsController {
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private ManageCharts_ChartService manageCharts_ChartService;
	@GetMapping(value="/quan-ly-thong-ke")
    //public String getPropertyChart(Model model ,Principal principal,HttpSession session)  {
	public String getPropertyChart(Model model ,Authentication authentication,HttpSession session)  {
		if (authentication instanceof OAuth2AuthenticationToken oauthToken) {
	        String oauthUsername=authentication.getName();
	        
	        return extractedGetPropertyChart(model, oauthUsername, session);
	    } else {
	        // local/form login
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        String username=userDetails.getUsername();
	        
	        return extractedGetPropertyChart(model, username, session);
	    }
		
		
    }
	private String extractedGetPropertyChart(Model model, String username, HttpSession session) {
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
					if(land.getLandID()==selectedLandID)
					{
						model.addAttribute("selectedLandID",land.getLandID());//to create-property belong to land
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
						
						//specific function_url start from here
						
						model.addAttribute("propertyRateChart",manageCharts_ChartService.getPropertyRateChart_ManageCharts(land.getLandID()) );
						//end specific function_url start from here
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
				
				//specific function_url start from here
				model.addAttribute("propertyRateChart",manageCharts_ChartService.getPropertyRateChart_ManageCharts(landList.get(0).getLandID()) );
				//end specific function_url start from here
			}
			return "manage_charts";
		}
	}
}
