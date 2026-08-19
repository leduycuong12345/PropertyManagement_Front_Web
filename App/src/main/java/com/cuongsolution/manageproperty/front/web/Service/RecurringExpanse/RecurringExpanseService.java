package com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse;


import java.util.List;
import java.util.UUID;

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
	public abstract List<ManageOrder_ExpanseHeaderDTO> manageOrder_findRecurringExpanseBelongToLand(UUID landID);
	public abstract List<ManageExpanse_RecurringExpanseDTO> manageExpanse_findRecurringExpanseBelongToLand(UUID landID); 
	public abstract void manageExpanse_deleteByID(UUID recurringExpanseID);
	public abstract void manageExpanse_editExpanseDTO(ManageExpanse_EditRecurringExpanseDTO editRecurringExpanseDTO);
	public abstract void manageExpanse_createRecurringExpanse(ManageExpanse_CreateRecurringExpanseDTO newExpanseDTO);
}
