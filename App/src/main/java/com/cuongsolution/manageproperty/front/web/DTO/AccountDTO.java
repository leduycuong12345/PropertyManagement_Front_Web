package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AccountDTO implements UserDetails{
	private long account_ID;
	private String username;
	private String password;
	private List<String> roles;
	
	public long getAccountID() {
		return account_ID;
	}
	public void setAccountID(long accountID) {
		this.account_ID = accountID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public AccountDTO() {
		super();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public long getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(long account_ID) {
		this.account_ID = account_ID;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
