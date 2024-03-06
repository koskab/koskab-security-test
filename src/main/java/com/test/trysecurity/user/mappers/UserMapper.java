package com.test.trysecurity.user.mappers;

import com.test.trysecurity.user.dto.UserCreate;
import com.test.trysecurity.user.dto.UserView;
import com.test.trysecurity.user.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserView toView(User entity);

    User toEntity(UserCreate userCreate);

}
