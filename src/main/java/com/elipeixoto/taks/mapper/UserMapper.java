package com.elipeixoto.taks.mapper;


import com.elipeixoto.taks.dto.UserDto;
import com.elipeixoto.taks.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    List<UserDto> toDtoList(List<User> users);
    List<User> toEntityList(List<UserDto> dtos);


}
