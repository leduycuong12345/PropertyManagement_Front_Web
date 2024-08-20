package com.cuongsolution.manageproperty.front.web.Model;

import java.io.Serializable;
public class AuthorityKey implements Serializable{
	private static final long serialVersionUID = -7066737070331009366L;

    private Long ownerID;

    private Long roleID;

	public Long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Long ownerID) {
		this.ownerID = ownerID;
	}

	public Long getRoleID() {
		return roleID;
	}

	public void setRoleID(Long roleID) {
		this.roleID = roleID;
	}
    
}
