package com.javatutorialshub.usermanagement.controller;

import com.javatutorialshub.usermanagement.exception.DeleteUserException;
import com.javatutorialshub.usermanagement.service.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class DeleteUserController {
    private final DeleteUserService deleteUserService;

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) throws DeleteUserException {
        deleteUserService.deleteUsers(List.of(userId));
    }
}
