package com.example.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.example.bank.dto.UserDto;
import com.example.bank.vo.UserVO;


@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

	    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	    public UserVO DTOtoVO(UserDto userDto);
	    public UserDto VOtoDTO(UserVO userVO);
	    public List<UserVO> toVOList(List<UserDto> userVO);
	}
