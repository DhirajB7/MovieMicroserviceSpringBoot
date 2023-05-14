package com.dhirajb7.userinfoservice.service;

import org.springframework.http.ResponseEntity;

import com.dhirajb7.userinfoservice.entity.User;

public interface UserServiceInterface {

	public ResponseEntity<Object> getUserByuserId(String userId);

	public ResponseEntity<Object> addUser(User userData);

	public ResponseEntity<Object> getAllUsers();

	public ResponseEntity<Object> editAUser(User userData);

	public ResponseEntity<Object> deleteAUser(String userId);

}
