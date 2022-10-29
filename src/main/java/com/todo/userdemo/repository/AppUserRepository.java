package com.todo.userdemo.repository;

import com.todo.userdemo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AppUserRepository extends JpaRepository<AppUser,Long> {
Optional<AppUser> findById(Long id);
}
