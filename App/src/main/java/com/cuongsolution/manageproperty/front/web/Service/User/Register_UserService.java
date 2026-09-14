package com.cuongsolution.manageproperty.front.web.Service.User;

import com.cuongsolution.manageproperty.front.web.DTO.Register_UserDTO;
import com.cuongsolution.manageproperty.front.web.DTO.Register_VerificationResultDTO;

public interface Register_UserService {
	public abstract boolean existsByEmail(String email);
	public abstract boolean existsByPhoneNumber(String phoneNumber);
	public abstract boolean createNewUser(Register_UserDTO user);
	public abstract boolean createNewUser_withVerificationMail(Register_UserDTO user);
	public abstract Register_VerificationResultDTO verifyEmailVerificationToken(String token);
	public abstract String resendVerifyEmailVerificationToken(String email);
}
