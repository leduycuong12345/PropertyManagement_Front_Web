package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class UserInfo_AccountDTO {
	private UUID account_ID;
	private String username;
	private String password;
	private UUID userId;
	private String userFirstName;
	private String userLastName;
	private String userCI;
	private String userPhoneNumber;
	private String userVerifiedEmail;
	private Date userRegisterdDate;
	private String userIP;
	private Boolean userIsEnabled;
	private List<String> roles;
	
	public Boolean getUserIsEnabled() {
		return userIsEnabled;
	}
	public void setUserIsEnabled(Boolean userIsEnabled) {
		this.userIsEnabled = userIsEnabled;
	}
	public UUID getAccountID() {
		return account_ID;
	}
	public void setAccountID(UUID accountID) {
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
	public UserInfo_AccountDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserInfo_AccountDTO() {
		super();
	}
	
	public UUID getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(UUID account_ID) {
		this.account_ID = account_ID;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserCI() {
		return userCI;
	}
	public void setUserCI(String userCI) {
		this.userCI = userCI;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserVerifiedEmail() {
		return userVerifiedEmail;
	}
	public void setUserVerifiedEmail(String userVerifiedEmail) {
		this.userVerifiedEmail = userVerifiedEmail;
	}
	public Date getUserRegisterdDate() {
		return userRegisterdDate;
	}
	public void setUserRegisterdDate(Date userRegisterdDate) {
		this.userRegisterdDate = userRegisterdDate;
	}
	public String getUserIP() {
		return userIP;
	}
	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}
	public UserInfo_AccountDTO(UUID account_ID, String username, String password, UUID userId, String userFirstName,
			String userLastName, String userCI, String userPhoneNumber, String userVerifiedEmail,
			Date userRegisterdDate, String userIP,
			 List<String> roles) {
		super();
		this.account_ID = account_ID;
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userCI = userCI;
		this.userPhoneNumber = userPhoneNumber;
		this.userVerifiedEmail = userVerifiedEmail;
		this.userRegisterdDate = userRegisterdDate;
		this.userIP = userIP;
		this.roles=roles;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
	
}
