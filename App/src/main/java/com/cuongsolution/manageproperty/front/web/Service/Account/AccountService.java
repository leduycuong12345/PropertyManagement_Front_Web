package com.cuongsolution.manageproperty.front.web.Service.Account;



import com.cuongsolution.manageproperty.front.web.DTO.AccountDTO;

public interface AccountService {
	public abstract AccountDTO findByUsername(String username);
	public abstract AccountDTO findByUsername_Production(String username);
}
