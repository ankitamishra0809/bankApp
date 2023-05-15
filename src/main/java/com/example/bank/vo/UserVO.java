package com.example.bank.vo;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Component
public class UserVO {
    @NotNull
	private String Id;
   @NotEmpty
	private String userName;

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserVO(String id, String userName) {
		super();
		Id = id;
		this.userName = userName;
	}

	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	




	

}	

