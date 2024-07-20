package com.javatutorialshub.usermanagement.service;

import com.javatutorialshub.usermanagement.entity.AbstractEntity;
import com.javatutorialshub.usermanagement.entity.User;
import com.javatutorialshub.usermanagement.exception.UpdateUserException;
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
public class UpdateUserService {
    private final UserRepository userRepository;

    @Transactional
    public void updateUsers(Collection<User> users) throws UpdateUserException {
        try {
            users.forEach(AbstractEntity::markNotNew);
            userRepository.saveAll(users);
        } catch (Exception e) {
            String message = String.format("A problem was encountered when " +
                    "attempting to update users with names: %s",
                    users.stream().map(User::getName).toList());
            log.log(Level.SEVERE, message);
            throw new UpdateUserException(e);
        }
    }
}
