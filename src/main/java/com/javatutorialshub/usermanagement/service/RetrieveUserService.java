package com.javatutorialshub.usermanagement.service;

import com.javatutorialshub.usermanagement.entity.User;
import com.javatutorialshub.usermanagement.exception.RetrieveUserException;
import com.javatutorialshub.usermanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.logging.Level;

@Service
@RequiredArgsConstructor
@Log
public class RetrieveUserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Collection<User> retrieveUsers(int page, int size) throws RetrieveUserException {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<User> users = userRepository.findAll(pageable);
            return users.getContent();
        } catch (Exception e) {
            String message = String.format("A problem was encountered when " +
                    "attempting to " +
                    "load users at page: %d and size: %d", page, size);
            log.log(Level.SEVERE, message);
            throw new RetrieveUserException(e);
        }
    }
}
