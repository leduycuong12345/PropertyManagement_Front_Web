package com.cuongsolution.manageproperty.front.web.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;

import jakarta.servlet.http.HttpSession;
@Controller
public class ManageNagivationController {
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@PostMapping(value="/land/create")
	public String postCreateLandPage( @ModelAttribute("newLand") ManageNavigation_FastCreateLandDTO newLand,Model model,Principal principal)  {
		this.landService.createLand_ManageNavigation_Production(newLand,principal.getName());
		//return "redirect:/land/list";
		return "redirect:/quan-ly";
    }
	@PostMapping(value="/land/edit")
	public String postEditLand( @RequestParam("landID") Long landID
			,@RequestParam("landName") String landName
			,@RequestParam("propertyRentalPrice") double propertyRentalPrice
			,@RequestParam("orderCreationDate") int orderCreationDate
			,@RequestParam("landAddress") String landAddress
			,@RequestParam("landAddressPostcode") String landAddressPostcode
			,Model model,Principal principal)  {
		ManageNavigation_FastCreateLandDTO editLand=new ManageNavigation_FastCreateLandDTO(landID,landName,propertyRentalPrice,orderCreationDate,landAddress,landAddressPostcode);
		this.landService.editLand_ManageNavigation_Production(editLand,principal.getName());
		//return "redirect:/land/list";
		return "redirect:/quan-ly";
    }
	@PostMapping(value="/land/delete")
	public String deleteLand( Model model,@RequestParam(value = "landID") Long landID,Principal principal,HttpSession session)  {
		this.landService.deleteLand_ManageNavigation_Production(landID,principal.getName());
		//return "redirect:/land/list";
		session.removeAttribute("selectedLandID");//if land is selected but user_deleted ll cause error because "selectedLandID" after removed cant retrieve from db anymore
		return "redirect:/quan-ly";
    }
}
