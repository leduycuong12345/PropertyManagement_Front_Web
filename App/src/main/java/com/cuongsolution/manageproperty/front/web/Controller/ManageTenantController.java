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

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageTenant_EditTenant_TenantDTO;
import com.cuongsolution.manageproperty.front.web.Service.Contract.ManageTenant_ContractService;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.Property.ManageTenant_PropertySer;
import com.cuongsolution.manageproperty.front.web.Service.Tenant.ManageTenant_TenantService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ManageTenantController {
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private ManageTenant_PropertySer propertyService;
	@Autowired
	private ManageTenant_ContractService contractService;
	@Autowired
	private ManageTenant_TenantService tenantSerive;
	@GetMapping(value="/quan-ly-khach-thue")
	public String managePropertyPage( HttpSession session,Model model,Principal principal)  {
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
						model.addAttribute("selectedLand",land );//to display selected-land-name at layout-sidebar
						model.addAttribute("propertyList",this.propertyService.getPropertyListIncludedTenantsByLandId(land.getLandID()));//tenant-list function
						model.addAttribute("editTenant",new ManageTenant_EditTenant_TenantDTO());//edit tenant function
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
				model.addAttribute("editTenant",new ManageTenant_EditTenant_TenantDTO());//edit tenant function

				model.addAttribute("propertyList",this.propertyService.getPropertyListIncludedTenantsByLandId(landList.get(0).getLandID()));//tenant-list function
			}
			return "manage_tenant";
		}
    }
	@PostMapping(value="/quan-ly-khach-thue")
	public String selectLandtoManage(@RequestParam("selectedLandID") Long selectedLandID, HttpSession session)  {
		session.setAttribute("selectedLandID", selectedLandID);
		return "redirect:/quan-ly-khach-thue";
	}
	@PostMapping(value="/quan-ly-khach-thue/xoa-khach-thue")
	public String deleteTenant(@RequestParam("contractID") Long contractID)  {
		this.contractService.manageTenant_DeleteContractForTenantByContractID(contractID);
		return "redirect:/quan-ly-khach-thue";
	}
	@PostMapping(value="/quan-ly-khach-thue/sua-thong-tin-khach-thue")
	public String editTenant(@ModelAttribute("editTenant") ManageTenant_EditTenant_TenantDTO editTenant)  {
		this.tenantSerive.editTenant_ManageTenant(editTenant);
		return "redirect:/quan-ly-khach-thue";
	}
}
