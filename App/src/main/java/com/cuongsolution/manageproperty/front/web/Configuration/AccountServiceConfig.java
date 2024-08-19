package com.cuongsolution.manageproperty.front.web.Configuration;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cuongsolution.manageproperty.front.web.DTO.AccountDTO;
import com.cuongsolution.manageproperty.front.web.Service.Account.AccountService;

@Service
public class AccountServiceConfig implements UserDetailsService {
	@Autowired
	private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  // Call your API to get user details
        AccountDTO userDto = this.accountService.findByUsername_Production(username); // Implement this method to call your API

        if (userDto == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(userDto.getUsername(), userDto.getPassword(), mapRoles(userDto.getRoles()));

	}
	private Collection<? extends GrantedAuthority> mapRoles(List<String> roles) {
        return roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }
}
