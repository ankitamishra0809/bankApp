package com.example.bank.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.bank.dto.UserDto;
import com.example.bank.mapper.UserMapper;
import com.example.bank.vo.UserVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDto findUserById(String id ) {
		String query="SELECT * FROM User where id = ? ";
		UserDto userDto =jdbcTemplate.queryForObject(query,BeanPropertyRowMapper.newInstance(UserDto.class),id);
		return userDto;
	}

	public void create(UserDto userDto) {
		String insertQuery = "insert into User  values (?)";
		jdbcTemplate.update(insertQuery, userDto);

	}
	
	public List<UserDto> findAllUsers()
	{
		String query = " select * from User";
		return jdbcTemplate.query(query,BeanPropertyRowMapper.newInstance(UserDto.class));
	}

}