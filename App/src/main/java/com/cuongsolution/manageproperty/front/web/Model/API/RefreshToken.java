package com.cuongsolution.manageproperty.front.web.Model.API;
import java.time.Instant;

public class RefreshToken {
    private long refresh_Token_ID;

    private Account account;

    private String token;

    private Instant expiry_Date;

	public long getRefreshToken_ID() {
		return refresh_Token_ID;
	}

	public void setRefreshToken_ID(long refreshToken_ID) {
		this.refresh_Token_ID = refreshToken_ID;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Instant getExpiryDate() {
		return expiry_Date;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiry_Date = expiryDate;
	}

	public RefreshToken( Account account, String token) {
		super();
		this.account = account;
		this.token = token;
	}

	public RefreshToken() {
		super();
	}
    
}
