package com.cuongsolution.manageproperty.front.web.Service.User;

import com.cuongsolution.manageproperty.front.web.DTO.Register_UserDTO;

public interface Register_UserService {
	public abstract boolean existsByEmail(String email);
	public abstract boolean existsByPhoneNumber(String phoneNumber);
	public abstract boolean createNewUser(Register_UserDTO user);
}
