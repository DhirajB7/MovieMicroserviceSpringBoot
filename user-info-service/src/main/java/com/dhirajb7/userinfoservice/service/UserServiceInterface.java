package com.dhirajb7.userinfoservice.service;

import org.springframework.http.ResponseEntity;

import com.dhirajb7.userinfoservice.entity.User;

interface UserServiceInterface {

	ResponseEntity<Object> getUserByuserId(String userId);

	ResponseEntity<Object> addUser(User userData);

	ResponseEntity<Object> getAllUsers();

	ResponseEntity<Object> editAUser(User userData);

	ResponseEntity<Object> deleteAUser(String userId);

}
