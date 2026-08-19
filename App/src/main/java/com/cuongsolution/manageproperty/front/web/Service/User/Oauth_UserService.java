package com.cuongsolution.manageproperty.front.web.Service.User;


import com.cuongsolution.manageproperty.front.web.DTO.OAuth2_GmailRegister_UserDTO;
import com.cuongsolution.manageproperty.front.web.DTO.Oauth_UserDTO;

public interface Oauth_UserService {

	public abstract Oauth_UserDTO getUserByGmail_OAuth2(String email);

	public abstract boolean createUserByGmail_OAuth2(OAuth2_GmailRegister_UserDTO oAuth2_GmailRegister_UserDTO);

}
