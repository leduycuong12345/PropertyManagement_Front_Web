package com.cuongsolution.manageproperty.front.web.Service.Account;



import com.cuongsolution.manageproperty.front.web.Model.Account;

public interface AccountService {
	public abstract Account findByUsername(String username);
	public abstract Account findByUsername_Production(String username);
}
