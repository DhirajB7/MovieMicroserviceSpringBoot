package com.dhirajb7.userinfoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhirajb7.userinfoservice.entity.User;
import com.dhirajb7.userinfoservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<Object> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping
	public ResponseEntity<Object> addUser(@RequestBody User userData) {
		return userService.addUser(userData);
	}

	@PutMapping
	public ResponseEntity<Object> editUser(@RequestBody User userData) {
		return userService.editAUser(userData);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Object> getOneUserDataById(@PathVariable("userId") String userId) {
		return userService.getUserByuserId(userId);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Object> deleteUserById(@PathVariable("userId") String userId) {
		return userService.deleteAUser(userId);
	}

}
