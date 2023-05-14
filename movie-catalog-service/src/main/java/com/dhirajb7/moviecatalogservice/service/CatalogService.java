package com.dhirajb7.moviecatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhirajb7.moviecatalogservice.repository.CatalogRepo;

@Service
public class CatalogService implements CatalogServiceInterface {

	@Autowired
	private CatalogRepo catalogRepo;

	@Override
	public ResponseEntity<Object> getCatalogForUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> getAllCatalogs() {
		return new ResponseEntity<Object>(catalogRepo.findAll(), HttpStatus.OK);
	}

}
