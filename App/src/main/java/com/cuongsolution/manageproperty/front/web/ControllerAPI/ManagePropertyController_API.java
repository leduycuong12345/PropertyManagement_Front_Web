package com.cuongsolution.manageproperty.front.web.ControllerAPI;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditPropertyDTO;
import com.cuongsolution.manageproperty.front.web.Service.Property.ManageProperty_PropertySer;
@RestController
public class ManagePropertyController_API {
	private Logger logger = LoggerFactory.getLogger(ManagePropertyController_API.class);
	
	@Autowired
	private ManageProperty_PropertySer propertyService;
	
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
