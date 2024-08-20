package com.cuongsolution.manageproperty.front.web.Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User {
	private long userId;
	private String userFirstName;
	private String userLastName;
	private String userCI;
	private String userPhoneNumber;
	private String userVerifiedEmail;
	private Date userRegisterdDate;
	private String userIP;
	
    private Account account;
	
	private List<Privilege> privileges = new ArrayList<>();
	
	public User(String userFirstName, String userLastName, String userPhoneNumber, String userVerifiedEmail) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPhoneNumber = userPhoneNumber;
		this.userVerifiedEmail = userVerifiedEmail;
	}

	private Set<Authority> authorities = new HashSet<>();
	
	private List<Privilege> privilegeList = new ArrayList<>();
	
	public User() {
		super();
	}
	public User(long userId, String userFirstName, String userLastName, String userCI, String userPhoneNumber,
			String userVerifiedEmail, Date userRegisterdDate, String userIP) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userCI = userCI;
		this.userPhoneNumber = userPhoneNumber;
		this.userVerifiedEmail = userVerifiedEmail;
		this.userRegisterdDate = userRegisterdDate;
		this.userIP = userIP;
	}
	
	public List<Privilege> getPrivilegeList() {
		return privilegeList;
	}
	public void setPrivilegeList(List<Privilege> privilegeList) {
		this.privilegeList = privilegeList;
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
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
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
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
