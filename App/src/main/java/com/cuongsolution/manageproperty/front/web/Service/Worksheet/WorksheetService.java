package com.cuongsolution.manageproperty.front.web.Service.Worksheet;

import java.util.List;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_BookDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateWorksheetDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageWorksheet_WorksheetDTO;
public interface WorksheetService {
	public abstract void createWorksheet_At_ManageProperty(ManageProperty_CreateWorksheetDTO worksheetDTO);
	public abstract void bookProperty_At_ManageProperty(ManageProperty_BookDTO bookDTO);
	public abstract void deleteWorksheet(long worksheetID);
	public abstract List<ManageWorksheet_WorksheetDTO> findAllBelongToLandID(long landID);
	public abstract void dropPrePaid_manageProperty(long worksheetID);
	public abstract void checkinProperty_manageProperty(long worksheetID);
}
