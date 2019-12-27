package com.psawesome.awsspringboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * package: com.psawesome.awsspringboot.domain.user
 * author: PS
 * DATE: 2019-12-27 금요일 23:21
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
