package com.cuongsolution.manageproperty.front.web.Model;


public class Privilege {
	private long Privilege_ID;
	
	private User user;
	
	private Land land;
	private boolean isOwner=true;
	
	public boolean isOwner() {
		return isOwner;
	}

	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}

	public long getPrivilege_ID() {
		return Privilege_ID;
	}

	public void setPrivilege_ID(long privilege_ID) {
		Privilege_ID = privilege_ID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Land getLand() {
		return land;
	}

	public void setLand(Land land) {
		this.land = land;
	}

	public Privilege() {
		super();
	}

	public Privilege(User user, Land land) {
		super();
		this.user = user;
		this.land = land;
	}
	
	
	
}
