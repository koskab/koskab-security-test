package com.test.trysecurity.user.repository;

import com.test.trysecurity.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
