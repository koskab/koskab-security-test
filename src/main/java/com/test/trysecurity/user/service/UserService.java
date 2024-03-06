package com.test.trysecurity.user.service;

import com.test.trysecurity.user.dto.UserCreate;
import com.test.trysecurity.user.dto.UserCreateResponse;
import com.test.trysecurity.user.dto.UserView;
import com.test.trysecurity.user.entity.User;

public interface UserService {

    UserCreateResponse create(UserCreate userCreate);

    UserView findById(Long id);

    User getEntityById(Long id);
}
