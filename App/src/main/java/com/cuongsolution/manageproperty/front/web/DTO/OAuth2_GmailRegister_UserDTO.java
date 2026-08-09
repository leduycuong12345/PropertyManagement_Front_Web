package com.cuongsolution.manageproperty.front.web.DTO;

public class OAuth2_GmailRegister_UserDTO {
    private String lastName;
    private String email;
    private String username;
    private String providerName;
    private String providerId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	public OAuth2_GmailRegister_UserDTO(String lastName, String email, String username, String providerName,
			String providerId) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.providerName = providerName;
		this.providerId = providerId;
	}
	public OAuth2_GmailRegister_UserDTO() {
		super();
	}
	
    
}
