package com.example.bank.dto;

import lombok.Data;

@Data
public class UserDto {

	private String Id;
	private String UserName;
	public UserDto(String id, String userName) {
		super();
		Id = id;
		UserName = userName;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	

}