package com.springboot.practice.data.repository;

import com.springboot.practice.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
