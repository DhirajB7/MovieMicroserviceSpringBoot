package com.dhirajb7.userinfoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhirajb7.userinfoservice.entity.User;
import com.dhirajb7.userinfoservice.pojo.MessageHolder;
import com.dhirajb7.userinfoservice.repository.UserRepo;

@Service
public class UserService implements UserServiceInterface{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public ResponseEntity<Object> getUserByuserId(String userId) {
		
		Object object = null;

		HttpStatus status = null;

		if (userRepo.existsById(userId)) {

			object = userRepo.findById(userId);

			status = HttpStatus.OK;

		} else {

			object = new MessageHolder(userId+" NOT FOUND");

			status = HttpStatus.NOT_FOUND;

		}

		return new ResponseEntity<Object>(object, status);
	}

	@Override
	public ResponseEntity<Object> addUser(User userData) {
		
		Object object = null;

		HttpStatus status = null;

		if (userRepo.existsById(userData.getUserId())) {

			object = new MessageHolder("USER DATA PRESENT");

			status = HttpStatus.CONFLICT;

		} else {

			object = userRepo.save(userData);

			status = HttpStatus.CREATED;

		}

		return new ResponseEntity<Object>(object, status);
	
	}

	@Override
	public ResponseEntity<Object> getAllUsers() {
		return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> editAUser(User userData) {

		Object object = null;

		HttpStatus status = null;

		if (userRepo.existsById(userData.getUserId())) {

			userRepo.deleteById(userData.getUserId());
			
			object = userRepo.save(userData);

			status = HttpStatus.OK;

		} else {

			object = userRepo.save(userData);

			status = HttpStatus.CREATED;

		}

		return new ResponseEntity<Object>(object, status);

	}

	@Override
	public ResponseEntity<Object> deleteAUser(String userId) {

		Object object = null;

		HttpStatus status = null;

		if (userRepo.existsById(userId)) {
			
			userRepo.deleteById(userId);

			object = new MessageHolder("USER DELETED");
			
			status = HttpStatus.OK;

		} else {

			object = new MessageHolder(userId+" NOT FOUND");

			status = HttpStatus.NOT_FOUND;

		}

		return new ResponseEntity<Object>(object, status);

	}

}
