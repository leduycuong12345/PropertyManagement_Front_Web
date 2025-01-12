package com.cuongsolution.manageproperty.front.web.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_CreateRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_EditRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.Property.ManageProperty_PropertySer;
import com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse.RecurringExpanseService;
import com.cuongsolution.manageproperty.front.web.Service.RecurringExpanseUnit.RecurringExpanseUnitService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageExpanseController {
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private RecurringExpanseService recurringExpanseService;
	@Autowired
	private RecurringExpanseUnitService recurringExpanseUnitService;
	@Autowired
	private ManageProperty_PropertySer propertyService;
	@GetMapping(value="/quan-ly-dich-vu")
	public String manageExpansePage( HttpSession session,Model model,Principal principal)  {
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
				List<ManageNavigation_FastCreateLandDTO> landList=this.landService.getDetailsLandList_ManageNavigation_Production(principal.getName());//for land list/delete/update func
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
	public String deleteRecurringExpanse(@RequestParam(value = "recurringExpanseID") Long recurringExpanseID) {
	  	this.recurringExpanseService.manageExpanse_deleteByID(recurringExpanseID);
		return "redirect:/quan-ly-dich-vu";
	}
	@PostMapping("/quan-ly-dich-vu/chinh-sua-dich-vu")
	public String editRecurringExpanse(/*@RequestParam(value = "recurringExpanseID") Long recurringExpanseID
			,@RequestParam(value = "recurringExpanseName") String recurringExpanseName
			,@RequestParam(value = "recurringExpanseUnitID") Long recurringExpanseUnitID
			,@RequestParam(value = "recurringExpansePrice") Float recurringExpansePrice
			@RequestParam(value = "selectedPropertyServiceIDList") List<Long> selectedPropertyServiceIDList,*/
			@ModelAttribute(value = "editRecurringExpanse") ManageExpanse_EditRecurringExpanseDTO editRecurringExpanse) {
		//System.out.println("select expanse id list:"+selectedPropertyServiceIDList);
		this.recurringExpanseService.manageExpanse_editExpanseDTO(editRecurringExpanse);
		return "redirect:/quan-ly-dich-vu";
	}
	@PostMapping("/quan-ly-dich-vu/them-dich-vu")
	public String createRecurringExpanse(/*@RequestParam(value = "recurringExpanseID") Long recurringExpanseID
			,@RequestParam(value = "recurringExpanseName") String recurringExpanseName
			,@RequestParam(value = "recurringExpanseUnitID") Long recurringExpanseUnitID
			,@RequestParam(value = "recurringExpansePrice") Float recurringExpansePrice
			@RequestParam(value = "selectedPropertyServiceIDList") List<Long> selectedPropertyServiceIDList,*/
			@ModelAttribute(value = "newExpanse") ManageExpanse_CreateRecurringExpanseDTO newExpanseDTO) {
		//System.out.println("select expanse id list:"+selectedPropertyServiceIDList);
		this.recurringExpanseService.manageExpanse_createRecurringExpanse(newExpanseDTO);
		return "redirect:/quan-ly-dich-vu";
	}

}
