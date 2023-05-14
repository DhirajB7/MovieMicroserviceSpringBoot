package com.dhirajb7.moviecatalogservice.service;

import org.springframework.http.ResponseEntity;

public interface CatalogServiceInterface {
	
	ResponseEntity<Object> getCatalogForUserId(String userId);
	
	ResponseEntity<Object> getAllCatalogs();

}
