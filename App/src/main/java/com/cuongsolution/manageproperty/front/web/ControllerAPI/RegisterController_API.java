package com.cuongsolution.manageproperty.front.web.ControllerAPI;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuongsolution.manageproperty.front.web.Service.User.Register_UserService;


@RestController
@RequestMapping("/api/register/auth")
public class RegisterController_API {
	private Logger logger = LoggerFactory.getLogger(RegisterController_API.class);
	@Autowired
	private Register_UserService register_UserService;
    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam("token") String token) {
    	Boolean result=this.register_UserService.verifyEmailVerificationToken(token);
    	if(result==false)
    	{
    		logger.info("RegisterController verify failed with token:",token);
    		return ResponseEntity.badRequest().body("Token expired");
    	}
    	else
    	{
    		logger.info("RegisterController verify successful with token:",token);
    		return ResponseEntity.ok("Account verified successfully");
    	}
    }
    @PostMapping("/resend-verification")
    public ResponseEntity<?> resend(@RequestParam String email) {
    	Boolean result=this.register_UserService.resendVerifyEmailVerificationToken(email);
    	logger.info("RegisterController resend failed with mail:",email);
    	if(result==false)
    	{
    		logger.info("RegisterController resend failed with mail:",email);
    		return ResponseEntity.ok(Map.of("message", "Verification email resent"));
    	}
    	else
    	{
    		logger.info("RegisterController resend successful with mail:",email);
    		return ResponseEntity.badRequest().body(Map.of("message", "Already verified"));
    	}
    }
}