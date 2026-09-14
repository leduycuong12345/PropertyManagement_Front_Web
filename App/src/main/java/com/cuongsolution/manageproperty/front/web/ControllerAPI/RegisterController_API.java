package com.cuongsolution.manageproperty.front.web.ControllerAPI;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuongsolution.manageproperty.front.web.Service.User.Register_UserService;


@RestController
public class RegisterController_API {
	private Logger logger = LoggerFactory.getLogger(RegisterController_API.class);
	@Autowired
	private Register_UserService register_UserService;
    @PostMapping("/api/register/auth/resend-verification")
    public ResponseEntity<?> resend(@RequestParam String email) {
    	String result=this.register_UserService.resendVerifyEmailVerificationToken(email);
    	logger.info("RegisterController resend failed with mail:",email);
    	if(result.equals("Verification email resent"))
    	{
    		logger.info("RegisterController resend successful with mail:",email);
    		return ResponseEntity.badRequest().body(Map.of("message", "Already verified"));
    	}
    	else
    	{
    		logger.info("RegisterController resend failed with mail:",email);
    		return ResponseEntity.ok(Map.of("message", "Verification email resent"));
    	}
    }
}