package com.cuongsolution.manageproperty.front.web.Service.Account;

import com.cuongsolution.manageproperty.front.web.DTO.UserInfo_AccountDTO;

public interface AccountService {
	public abstract UserInfo_AccountDTO findByUsername(String username);
	public abstract UserInfo_AccountDTO findByUsername_Production(String username);
}
