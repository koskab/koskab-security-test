package com.test.trysecurity.user.controllers;

import com.test.trysecurity.user.dto.UserCreate;
import com.test.trysecurity.user.dto.UserCreateResponse;
import com.test.trysecurity.user.dto.UserView;
import com.test.trysecurity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public UserCreateResponse create(@RequestBody UserCreate userCreate){
        return service.create(userCreate);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public UserView findById(@PathVariable Long id){
        return service.findById(id);
    }

}
