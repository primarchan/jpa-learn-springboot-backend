package com.example.jpalearnproject.security.repository;

import com.example.jpalearnproject.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

}
