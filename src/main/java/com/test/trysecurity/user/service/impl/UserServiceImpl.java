package com.test.trysecurity.user.service.impl;

import com.test.trysecurity.user.dto.UserCreate;
import com.test.trysecurity.user.dto.UserCreateResponse;
import com.test.trysecurity.user.dto.UserView;
import com.test.trysecurity.user.entity.User;
import com.test.trysecurity.user.mappers.UserMapper;
import com.test.trysecurity.user.repository.UserRepository;
import com.test.trysecurity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserCreateResponse create(UserCreate userCreate){
        validateUserCreate(userCreate);
        User user = UserMapper.INSTANCE.toEntity(userCreate);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = repository.save(user);
        return new UserCreateResponse(user.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public UserView findById(Long id){
        User user = getEntityById(id);
        return UserMapper.INSTANCE.toView(user);
    }

    @Override
    @Transactional
    public User getEntityById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private void validateUserCreate(UserCreate userCreate){

        if(repository.existsByEmail(userCreate.getEmail())){
            throw new RuntimeException("User with this email already exists");
        }

        if(StringUtils.isBlank(userCreate.getPassword())
                || StringUtils.isBlank(userCreate.getRePassword())
                || !userCreate.getPassword().equals(userCreate.getRePassword()))
            throw new RuntimeException("Incorrect input in passwords fields");

    }

}
