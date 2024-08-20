package com.cuongsolution.manageproperty.front.web.Model;

public class Authority {
    private AuthorityKey Id;
	
    private Role role;

   private User user;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Authority() {
		super();
	}

	public Authority(AuthorityKey id, Role role, User user) {
		super();
		Id = id;
		this.role = role;
		this.user = user;
	}
    
}
