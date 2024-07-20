package com.javatutorialshub.usermanagement.controller;

import com.javatutorialshub.usermanagement.entity.User;
import com.javatutorialshub.usermanagement.exception.CreateUserException;
import com.javatutorialshub.usermanagement.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class CreateUserController {
    private final CreateUserService createUserService;

    @PostMapping
    public void createUsers(@RequestBody Collection<User> users) throws CreateUserException {
        createUserService.createUsers(users);
    }
}
