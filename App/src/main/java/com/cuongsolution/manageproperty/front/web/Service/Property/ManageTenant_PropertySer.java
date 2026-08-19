package com.cuongsolution.manageproperty.front.web.Service.Property;

import java.util.List;
import java.util.UUID;

import com.cuongsolution.manageproperty.front.web.DTO.ManageTenant_PropertyDTO;

public interface ManageTenant_PropertySer {
	public abstract List<ManageTenant_PropertyDTO> getPropertyListIncludedTenantsByLandId(UUID landID);
}
