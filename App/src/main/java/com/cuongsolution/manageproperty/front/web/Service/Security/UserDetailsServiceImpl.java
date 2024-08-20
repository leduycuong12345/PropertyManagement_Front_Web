package com.cuongsolution.manageproperty.front.web.Service.Security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cuongsolution.manageproperty.front.web.Model.Account;
import com.cuongsolution.manageproperty.front.web.Model.Authority;
import com.cuongsolution.manageproperty.front.web.Service.Account.AccountService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AccountService accountDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account=this.accountDAO.findByUsername(username);
		//Account account=this.accountDAO.findByUsername_Production(username);
		
       if (account.getUser().getUserFirstName() == null) {
           System.out.println("User not found! " + username);
           throw new UsernameNotFoundException("User " + username + " was not found in the database");
       }

       System.out.println("Found User: " + account.getUsername());

       // [ROLE_USER, ROLE_ADMIN,..]
       List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
       if (account.getAuthorities() != null) {
           //load user from db
    	   for (Authority author: account.getUser().getAuthorities()) {
               // ROLE_USER, ROLE_ADMIN,..
               GrantedAuthority authority = new SimpleGrantedAuthority(author.getRole().getRoleName());
               grantList.add(authority);
           }
       }
       
       UserDetails userDetails = (UserDetails) new User(account.getUsername(), //
    		   account.getPassword(), grantList);

       return userDetails;
	}

}
