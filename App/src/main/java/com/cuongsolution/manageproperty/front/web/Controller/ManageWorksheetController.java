package com.cuongsolution.manageproperty.front.web.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.Worksheet.WorksheetService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageWorksheetController {
	@Autowired
	private WorksheetService worksheetService;
	@Autowired
	private ManageNavigation_LandService_Production landService;
	/*@PostMapping("/hop-dong/them")
	
	 * public String
	 * createWorksheet_PropertyManagePage(@ModelAttribute("newWorksheet")
	 * ManageProperty_CreateWorksheetDTO newWorksheet) { // Process the submitted
	 * form data // ...
	 * this.worksheetService.createWorksheet_At_ManageProperty(newWorksheet); return
	 * "redirect:/quan-ly"; }
	 */
	@GetMapping(value="/quan-ly-hop-dong")
	public String getWorksheetList(HttpSession session, Model model,Principal principal) throws Exception {
		if(this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName()).isEmpty())//kiem tra xem ng dung da khoi tao Land chua? chua thi khoi tao
		{
			model.addAttribute("newLand", new ManageNavigation_FastCreateLandDTO());//for create land func
			return "new_user";
			
		}
		else
		{
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
						model.addAttribute("selectedLand",land);//to display selected-land-name at layout-sidebar
						model.addAttribute("worksheetList", this.worksheetService.findAllBelongToLandID(selectedLandID));//for worksheet-list function
					}
				}
			}
			else//neu chua chon land
			{
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
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
    public String deleteWorksheet(@RequestParam("worksheetID") Long worksheetID) {
		//System.out.println(property);
    	this.worksheetService.deleteWorksheet(worksheetID);
    	//System.out.println(result);
    	return "redirect:/quan-ly";
    }
}

