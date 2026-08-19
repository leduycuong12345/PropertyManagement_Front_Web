package com.cuongsolution.manageproperty.front.web.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.cuongsolution.manageproperty.front.web.Model.API.Authority;
import com.cuongsolution.manageproperty.front.web.Model.API.Privilege;

public class Oauth_UserDTO {
	private UUID userId;
	private String userFirstName;
	private String userLastName;
	private String userCI;
	private String userPhoneNumber;
	private String userVerifiedEmail;
	private Date userRegisterdDate;
	private String userIP;
	private Boolean userIsEnabled;
	private boolean isPresenting;

	//private Set<Authority> authorities = new HashSet<>();
	
	//private List<Privilege> privilegeList = new ArrayList<>();
	public boolean isPresenting() {
		return isPresenting;
	}
	public void setPresenting(boolean isPresenting) {
		this.isPresenting = isPresenting;
	}
	public Boolean getUserIsEnabled() {
		return userIsEnabled;
	}
	public void setUserIsEnabled(Boolean userIsEnabled) {
		this.userIsEnabled = userIsEnabled;
	}
	public Oauth_UserDTO(String userFirstName, String userLastName, String userPhoneNumber, String userVerifiedEmail) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPhoneNumber = userPhoneNumber;
		this.userVerifiedEmail = userVerifiedEmail;
	}

	
	public Oauth_UserDTO() {
		super();
	}
	public Oauth_UserDTO(UUID userId, String userFirstName, String userLastName, String userCI, String userPhoneNumber,
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
}
