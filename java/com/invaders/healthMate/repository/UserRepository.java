package com.invaders.healthMate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.invaders.healthMate.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}


