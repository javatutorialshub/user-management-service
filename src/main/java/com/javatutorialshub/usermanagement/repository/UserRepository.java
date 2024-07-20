package com.javatutorialshub.usermanagement.repository;

import com.javatutorialshub.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
