package com.javatutorialshub.usermanagement.controller;

import com.javatutorialshub.usermanagement.entity.User;
import com.javatutorialshub.usermanagement.exception.RetrieveUserException;
import com.javatutorialshub.usermanagement.service.RetrieveUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class RetrieveUserController {
    private final RetrieveUserService retrieveUserService;

    @GetMapping
    public Collection<User> getUsers(@RequestParam("page") int page,
                                     @RequestParam("size") int size) throws RetrieveUserException {
        return retrieveUserService.retrieveUsers(page, size);
    }
}
