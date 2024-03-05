package com.test.trysecurity.user.mappers;

import com.test.trysecurity.user.dto.UserCreate;
import com.test.trysecurity.user.entity.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface UserMapper {

    User toEntity(UserCreate userCreate);

}
