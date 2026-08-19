package com.cuongsolution.manageproperty.front.web.Service.Property;

import java.util.List;
import java.util.UUID;

import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_PropertyDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditPropertyDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_PropertyDTO;

public interface ManageProperty_PropertySer {
	public abstract void createProperty(String propertyName,double propertyRentalPrice,UUID landID);
	public abstract void deleteById(UUID propertyID);
	public abstract List<ManageProperty_PropertyDTO> getPropertyBelongToLand_ManageProperty(UUID landID);
	public abstract void editProperty_ManageProperty(ManageProperty_EditPropertyDTO propertyDTO);
	public abstract void editPropertyIncludedWorksheet(ManageProperty_PropertyDTO propertyDTO);
	public abstract List<ManageExpanse_PropertyDTO> manageExpanse_createExpanse_getPropertyListBelongToLand(UUID landID);

}
