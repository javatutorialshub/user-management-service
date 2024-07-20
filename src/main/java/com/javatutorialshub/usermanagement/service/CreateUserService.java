package com.javatutorialshub.usermanagement.service;

import com.javatutorialshub.usermanagement.entity.User;
import com.javatutorialshub.usermanagement.exception.CreateUserException;
import com.javatutorialshub.usermanagement.exception.RetrieveUserException;
import com.javatutorialshub.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.logging.Level;

@Service
@RequiredArgsConstructor
@Log
public class CreateUserService {
    private final UserRepository userRepository;

    @Transactional
    public void createUsers(Collection<User> users) throws CreateUserException {
        try {
            userRepository.saveAll(users);
        } catch (Exception e) {
            String message = String.format("A problem was encountered when " +
                    "attempting to create users with names: %s",
                    users.stream().map(User::getName).toList());
            log.log(Level.SEVERE, message);
            throw new CreateUserException(e);
        }
    }
}
