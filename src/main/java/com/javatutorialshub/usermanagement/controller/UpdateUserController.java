package com.javatutorialshub.usermanagement.controller;

import com.javatutorialshub.usermanagement.entity.User;
import com.javatutorialshub.usermanagement.exception.UpdateUserException;
import com.javatutorialshub.usermanagement.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UpdateUserController {
    private final UpdateUserService updateUserService;

    @PutMapping
    public void updateUsers(@RequestBody Collection<User> users) throws UpdateUserException {
        updateUserService.updateUsers(users);
    }
}
