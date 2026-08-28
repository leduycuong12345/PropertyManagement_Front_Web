package com.cuongsolution.manageproperty.front.web.Service.RecurringExpanse;


import java.util.List;
import java.util.UUID;

import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_CreateRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_EditRecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageExpanse_RecurringExpanseDTO;
import com.cuongsolution.manageproperty.front.web.DTO.ManageOrder_ExpanseHeaderDTO;



public interface RecurringExpanseService {
	public abstract List<ManageOrder_ExpanseHeaderDTO> manageOrder_findRecurringExpanseBelongToLand(UUID landID);
	public abstract List<ManageExpanse_RecurringExpanseDTO> manageExpanse_findRecurringExpanseBelongToLand(UUID landID); 
	public abstract void manageExpanse_deleteByID(UUID recurringExpanseID);
	public abstract void manageExpanse_editExpanseDTO(ManageExpanse_EditRecurringExpanseDTO editRecurringExpanseDTO);
	public abstract void manageExpanse_createRecurringExpanse(ManageExpanse_CreateRecurringExpanseDTO newExpanseDTO);
}
