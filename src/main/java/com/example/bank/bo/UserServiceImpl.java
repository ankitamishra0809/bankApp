package com.example.bank.bo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bank.dao.UserRepository;
import com.example.bank.dto.UserDto;
import com.example.bank.mapper.UserMapper;
import com.example.bank.vo.UserVO;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	UserMapper userMapper;
	@Override
	public List<UserVO> getUser(){
		List<UserDto> userDto = userRepo.findAllUsers();
		
		return userMapper.toVOList(userDto);
	}
	@Override
	  public void saveAndUpdate(UserVO userVO) {
	      userRepo.create(userMapper.VOtoDTO(userVO));
	   }
	@Override
	public UserVO getUserById(String id ) {
		UserDto userDto = userRepo.findUserById(id);
		if(userDto != null) {
			return userMapper.DTOtoVO(userDto);
	} 
			else {
		throw new UserNotFoundException("User not found with id:" + id);
		}
		
	}
	}


