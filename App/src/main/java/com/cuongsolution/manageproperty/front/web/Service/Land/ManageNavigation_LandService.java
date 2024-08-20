package com.cuongsolution.manageproperty.front.web.Service.Land;

import java.util.List;

import com.cuongsolution.manageproperty.front.web.DTO.ManageNavigation_FastCreateLandDTO;


public interface ManageNavigation_LandService {
	public abstract List<ManageNavigation_FastCreateLandDTO> getDetailsLandList_ManageNavigation();
	public abstract ManageNavigation_FastCreateLandDTO createLand_ManageNavigation(ManageNavigation_FastCreateLandDTO landDTO);
	public abstract void deleteLand_ManageNavigation(long landID);
	public abstract void editLand_ManageNavigation(ManageNavigation_FastCreateLandDTO landDTO);
}
