package com.bip.api.dtos;

import java.util.Date;

import org.bson.types.ObjectId;

import com.bip.api.enums.PerfilEnum;

public class UserDto {

	private ObjectId _id;
	private boolean  isActivated;
	private String   email;
	private PerfilEnum   userTypeAccess;
	private Date     createdAt;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public PerfilEnum getUserTypeAccess() {
		return userTypeAccess;
	}
	public void setUserTypeAccess(PerfilEnum userTypeAccess) {
		this.userTypeAccess = userTypeAccess;
	}
	@Override
	public String toString() {
		return "UserDto [_id=" + _id + ", isActivated=" + isActivated + ", email=" + email + ", userTypeAccess="
				+ userTypeAccess + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	 
}
