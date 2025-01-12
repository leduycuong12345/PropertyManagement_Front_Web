package com.cuongsolution.manageproperty.front.web.Service.PropertyService;

import java.util.List;
import java.util.Optional;

import com.cuongsolution.manageproperty.front.web.DTO.ManageProperty_EditFastRecurringExpanseListDTO;
import com.cuongsolution.manageproperty.front.web.Model.API.Property;
import com.cuongsolution.manageproperty.front.web.Model.API.PropertyService;
import com.cuongsolution.manageproperty.front.web.Model.API.RecurringExpanse;

public interface PropertyServiceSer {
	public abstract void fastEditExpanseList(ManageProperty_EditFastRecurringExpanseListDTO editFastExpanseList);
}
