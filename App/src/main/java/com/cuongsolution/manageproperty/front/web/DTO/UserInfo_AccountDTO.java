package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.Date;
import java.util.List;


public class UserInfo_AccountDTO {
	private long account_ID;
	private String username;
	private String password;
	private long userId;
	private String userFirstName;
	private String userLastName;
	private String userCI;
	private String userPhoneNumber;
	private String userVerifiedEmail;
	private Date userRegisterdDate;
	private String userIP;
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
	public UserInfo_AccountDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public UserInfo_AccountDTO() {
		super();
	}
	
	public long getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(long account_ID) {
		this.account_ID = account_ID;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
	public UserInfo_AccountDTO(long account_ID, String username, String password, long userId, String userFirstName,
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
