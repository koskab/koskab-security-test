package com.test.trysecurity.user.repository;

import com.test.trysecurity.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<Object> findByEmail(String email);
}
