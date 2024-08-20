package com.cuongsolution.manageproperty.front.web.Model;

import java.time.Instant;

public class TenantRefreshToken {
    private long tenant_Refresh_Token_ID;

    private TenantAccount tenantAccount;

    private String tenant_Token;

    private Instant tenant_Expiry_Date;

	public long getRefreshToken_ID() {
		return tenant_Refresh_Token_ID;
	}

	public void setRefreshToken_ID(long refreshToken_ID) {
		this.tenant_Refresh_Token_ID = refreshToken_ID;
	}


	public String getToken() {
		return tenant_Token;
	}

	public void setToken(String token) {
		this.tenant_Token = token;
	}

	public Instant getExpiryDate() {
		return tenant_Expiry_Date;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.tenant_Expiry_Date = expiryDate;
	}

	public TenantRefreshToken( TenantAccount tenantAccount, String token) {
		super();
		this.tenantAccount= tenantAccount;
		this.tenant_Token = token;
	}

	public TenantRefreshToken() {
		super();
	}
    
}
