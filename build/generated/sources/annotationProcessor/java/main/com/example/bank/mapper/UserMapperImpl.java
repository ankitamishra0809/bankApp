package com.example.bank.mapper;

import com.example.bank.dto.UserDto;
import com.example.bank.vo.UserVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T13:42:23+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserVO DTOtoVO(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( userDto.getId() );
        userVO.setUserName( userDto.getUserName() );

        return userVO;
    }

    @Override
    public UserDto VOtoDTO(UserVO userVO) {
        if ( userVO == null ) {
            return null;
        }

        String id = null;
        String userName = null;

        id = userVO.getId();
        userName = userVO.getUserName();

        UserDto userDto = new UserDto( id, userName );

        return userDto;
    }

    @Override
    public List<UserVO> toVOList(List<UserDto> userVO) {
        if ( userVO == null ) {
            return null;
        }

        List<UserVO> list = new ArrayList<UserVO>( userVO.size() );
        for ( UserDto userDto : userVO ) {
            list.add( DTOtoVO( userDto ) );
        }

        return list;
    }
}
