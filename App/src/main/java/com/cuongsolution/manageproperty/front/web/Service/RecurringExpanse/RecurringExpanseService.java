package com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse;


import java.util.List;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_RecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.Model.API.DetailsRecurringExpanse;
import com.cuongsolution.manageproperty.front.web.Model.API.Property;
import com.cuongsolution.manageproperty.front.web.Model.API.RecurringExpanse;
import com.cuongsolution.manageproperty.front.web.Model.API.Worksheet;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_CreateRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_EditRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_RecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ExpanseHeaderDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_CreateWorksheetDTO;



public interface RecurringExpanseService {
	public abstract RecurringExpanse add(RecurringExpanse recurringExpanse);
	public abstract RecurringExpanse findById(long recurringExpanseID);
	public abstract void delete(long recurringExpanseID);
	public abstract List<ManageProperty_RecurringExpanseDTO> findRecurringExpanseBelongToLand(long landID);
	public abstract List<ManageOrder_ExpanseHeaderDTO> manageOrder_findRecurringExpanseBelongToLand(long landID);
	public abstract List<ManageProperty_RecurringExpanseDTO> findRecurringExpanseBelongToProperty(Property property);
	public abstract List<ManageOrder_ExpanseDTO> manageOrder_findRecurringExpanseBelongToProperty(long landID,List<DetailsRecurringExpanse> detailsOrder_RecurringExpanseList);
	public abstract List<ManageProperty_RecurringExpanseDTO> findRecurringExpanseBelongToWorksheet(Worksheet worksheet);
	public abstract void setRecurringExpanseList_ForWorksheet_CreateWorksheet(ManageProperty_CreateWorksheetDTO worksheetDTO,Worksheet worksheet);
	public abstract List<ManageExpanse_RecurringExpanseDTO> manageExpanse_findRecurringExpanseBelongToLand(long landID); 
	public abstract void manageExpanse_deleteByID(long recurringExpanseID);
	public abstract void manageExpanse_editExpanseDTO(ManageExpanse_EditRecurringExpanseDTO editRecurringExpanseDTO);
	public abstract void manageExpanse_createRecurringExpanse(ManageExpanse_CreateRecurringExpanseDTO newExpanseDTO);
}
