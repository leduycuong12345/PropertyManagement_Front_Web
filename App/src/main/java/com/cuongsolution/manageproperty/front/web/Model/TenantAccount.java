package com.cuongsolution.manageproperty.front.web.Model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class TenantAccount  implements UserDetails{
	private long tenant_Account_ID;
	private String tenant_Username;
	private String tenant_Password;
	
	private Tenant tenant;

	private TenantRefreshToken tenantRefreshToken;
	
	
	public long getTenant_Account_ID() {
		return tenant_Account_ID;
	}
	public void setTenant_Account_ID(long tenant_Account_ID) {
		this.tenant_Account_ID = tenant_Account_ID;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	public TenantRefreshToken getTenantRefreshToken() {
		return tenantRefreshToken;
	}
	public void setTenantRefreshToken(TenantRefreshToken tenantRefreshToken) {
		this.tenantRefreshToken = tenantRefreshToken;
	}
	public String getTenant_Username() {
		return tenant_Username;
	}
	public void setTenant_Username(String tenant_Username) {
		this.tenant_Username = tenant_Username;
	}
	public String getTenant_Password() {
		return tenant_Password;
	}
	public void setTenant_Password(String tenant_Password) {
		this.tenant_Password = tenant_Password;
	}
	public TenantAccount() {
		super();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
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
	
}
