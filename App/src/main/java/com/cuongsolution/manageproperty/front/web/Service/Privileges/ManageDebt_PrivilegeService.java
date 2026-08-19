package com.cuongsolution.manageproperty.front.web.Service.Privileges;

import java.util.UUID;

public interface ManageDebt_PrivilegeService {
	public abstract boolean isWorksheetBelongToUser(UUID worksheetId,String username);
}
