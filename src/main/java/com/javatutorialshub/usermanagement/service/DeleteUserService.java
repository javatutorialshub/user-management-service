package com.javatutorialshub.usermanagement.service;

import com.javatutorialshub.usermanagement.exception.DeleteUserException;
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
public class DeleteUserService {
    private final UserRepository userRepository;

    @Transactional
    public void deleteUsers(Collection<String> userIds) throws DeleteUserException {
        try {
            userRepository.deleteAllById(userIds);
        } catch (Exception e) {
            String message = String.format("A problem was encountered when " +
                    "attempting to delete users with ids: %s",
                    userIds);
            log.log(Level.SEVERE, message);
            throw new DeleteUserException(e);
        }
    }
}
