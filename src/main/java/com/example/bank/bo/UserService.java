package com.example.bank.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.dto.UserDto;
import com.example.bank.vo.UserVO;

@Service

public interface UserService {

@Autowired
	public List<UserVO> getUser();
	public void saveAndUpdate(UserVO userVO);
	public UserVO getUserById(String id);
}
