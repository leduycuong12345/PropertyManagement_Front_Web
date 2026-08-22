package com.cuongsolution.manageproperty.front.web.Service.Security.OauthService;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.cuongsolution.manageproperty.front.web.DTO.OAuth2_GmailRegister_UserDTO;
import com.cuongsolution.manageproperty.front.web.DTO.Oauth_UserDTO;
import com.cuongsolution.manageproperty.front.web.Service.User.Oauth_UserService;

@Service
public class CustomOAuth2UserService
        extends DefaultOAuth2UserService {
	private Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);
	
	@Autowired
	private Oauth_UserService oauth_UserService;
    @Override
    public OAuth2User loadUser(
            OAuth2UserRequest request)
            throws OAuth2AuthenticationException {

        OAuth2User oauthUser =
                super.loadUser(request);
        
        
        // Save/update database if email s new then create new user.
        
        // Provider information
        String provider = request.getClientRegistration().getRegistrationId();
     // User information
        String email = oauthUser.getAttribute("email");
        String name = oauthUser.getAttribute("name");
        String googleId = oauthUser.getAttribute("sub");
        String generated_username=name+"_"+googleId;
        logger.info(" CustomOAuth2UserService loadUser email:{},name:{},sub:{},username:{}",email,name,googleId,generated_username);
        Oauth_UserDTO isUserPresenting=this.oauth_UserService.getUserByGmail_OAuth2(
        		email
        		);
        if(isUserPresenting.isPresenting())//is user registered or not
        {
        	if(isUserPresenting.getUserIsEnabled()==false)
        	{
        		//user regiser account by local and access by oauth2 but not verify yet 
        		//=>force user to email_verification.
        		throw new DisabledException("Account is not activated.");
        	}
        	else
        	{	
        		//account is registered and activated then return 
        		//return oauthUser;
        		Map<String, Object> attributes = new HashMap<>(oauthUser.getAttributes());
        		attributes.put("username", generated_username); // <-- put the VALUE into the map under a KEY
                return new DefaultOAuth2User(
                        oauthUser.getAuthorities(),
                        attributes,
                        "username"  // <-- this is the fix: nameAttributeKey now points at "email"
                );
        	}
        }
        else //dont have account yet then registering
        {
        	logger.info(" CustomOAuth2UserService loadUser email:{},name:{},sub:{},username:{}",email,name,googleId,generated_username);
        	
        	OAuth2_GmailRegister_UserDTO dto=new OAuth2_GmailRegister_UserDTO(
					name,
					email,
					generated_username,
					"GOOGLE",//gmail belong to google ofc
					googleId
					);
        	
        	boolean createNewUserResult=this.oauth_UserService.createUserByGmail_OAuth2(
        			dto
        			);
            /*while(createNewUserResult==false)
            {
            	// Pause execution for 2000 milliseconds (2 seconds)
                try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }*/
        }
        //return oauthUser;
        // fix Principal.getName() to return email instead of sub
        Map<String, Object> attributes = new HashMap<>(oauthUser.getAttributes());
        attributes.put("username", generated_username); // <-- put the VALUE into the map under a KEY
        return new DefaultOAuth2User(
                oauthUser.getAuthorities(),
                attributes,
                "username" // <-- this is the fix: nameAttributeKey now points at "email"
        );
    }
}