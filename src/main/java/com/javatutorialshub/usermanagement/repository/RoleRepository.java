package com.javatutorialshub.usermanagement.repository;

import com.javatutorialshub.usermanagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
