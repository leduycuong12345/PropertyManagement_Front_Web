package com.cuongsolution.manageproperty.front.web.Service.Land;

import java.util.List;
import java.util.UUID;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;


public interface ManageNavigation_LandService_Production {
	public abstract List<ManageNavigation_FastCreateLandDTO> getDetailsLandList_ManageNavigation_Production(String username);
	public abstract void createLand_ManageNavigation_Production(ManageNavigation_FastCreateLandDTO landDTO,String username);
	public abstract void deleteLand_ManageNavigation_Production(UUID landID,String username);
	public abstract void editLand_ManageNavigation_Production(ManageNavigation_FastCreateLandDTO landDTO,String username);
}
