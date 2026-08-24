package com.cuongsolution.manageproperty.front.web.ControllerAPI;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_AddTenantToWorksheetDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_BookDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateOrderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateWorksheetDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_DepositDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditFastRecurringExpanseListDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditPropertyDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_FastCreateOrderListDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_PropertyDTO;
import com.cuongsolution.manageproperty.front.web.Service.Land.ManageNavigation_LandService_Production;
import com.cuongsolution.manageproperty.front.web.Service.OrderInfo.ManageProperty_OrderInfoService;
import com.cuongsolution.manageproperty.front.web.Service.Property.ManageProperty_PropertySer;
import com.cuongsolution.manageproperty.front.web.Service.PropertyService.PropertyServiceSer;
import com.cuongsolution.manageproperty.front.web.Service.Tenant.TenantService;
import com.cuongsolution.manageproperty.front.web.Service.Worksheet.WorksheetService;
@RestController
public class ManagePropertyController_API {
	private Logger logger = LoggerFactory.getLogger(ManagePropertyController_API.class);
	
	@Autowired
	private ManageNavigation_LandService_Production landService;
	@Autowired
	private ManageProperty_PropertySer propertyService;
	@Autowired
	private PropertyServiceSer propertyServiceSer;
	@Autowired
	private TenantService tenantService;
	@Autowired
	private ManageProperty_OrderInfoService manageProperty_OrderInfoService;
    @Autowired
	private WorksheetService worksheetService;
	
	/*
	@PostMapping("/quan-ly/sua-tai-san")
    public ResponseEntity<String>  editProperty_ManageProperty(@Validated @RequestBody ManageProperty_EditPropertyDTO property) throws Exception {
		logger.info("ManagePropertyController editProperty_ManageProperty propertyID:{},propertyName:{},"
				+ "propertyRentalName:{},timeInterval:{},deposit:{},orderCreationDate:{}",
				property.getPropertyID(),property.getPropertyName(),property.getPropertyRentalPrice(),
				property.getWorksheetTimeInverval(),property.getWorksheetTotalDeposit(),property.getWorksheetOrderCreationDate());
		this.propertyService.editProperty_ManageProperty(property);
		return ResponseEntity.ok("Đã lưu đối tượng thành công!");
    }*/
    @PostMapping("/quan-ly/sua-tai-san")
    public ResponseEntity<String>  editProperty_ManageProperty(@Validated @RequestBody ManageProperty_EditPropertyDTO property) throws Exception {
		logger.info("ManagePropertyController_API editProperty_ManageProperty propertyID:{},propertyName:{},"
				+ "propertyRentalPrice:{},timeInterval:{},deposit:{},orderCreationDate:{}",
				property.getPropertyID(),property.getPropertyName(),property.getPropertyRentalPrice(),
				property.getWorksheetTimeInverval(),property.getWorksheetTotalDeposit(),property.getWorksheetOrderCreationDate());
		this.propertyService.editProperty_ManageProperty(property);
		return ResponseEntity.ok("Đã lưu đối tượng thành công!");
    }
}
