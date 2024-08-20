package com.cuongsolution.manageproperty.front.web.Model;
import java.util.HashSet;
import java.util.Set;


public class Role {
	private Long roleId;

	private String roleName;
	
    private Set<Authority> authorities = new HashSet<>();


	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	

	public Long getRoleId() {
		return roleId;
	}



	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public Role() {
		super();
	}
	

}
