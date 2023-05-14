package com.dhirajb7.userinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhirajb7.userinfoservice.entity.User;

public interface UserRepo extends JpaRepository<User, String> {

}
