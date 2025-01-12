package com.cuongsolution.manageproperty.front.web.Service.Property;

import java.util.List;

import com.cuongsolution.manageproperty.front.web.DTO.ManageTenant_PropertyDTO;

public interface ManageTenant_PropertySer {
	public abstract List<ManageTenant_PropertyDTO> getPropertyListIncludedTenantsByLandId(Long landID);
}
