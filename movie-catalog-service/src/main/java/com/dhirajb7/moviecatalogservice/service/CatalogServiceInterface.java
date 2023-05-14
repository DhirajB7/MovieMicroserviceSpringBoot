package com.dhirajb7.moviecatalogservice.service;

import org.springframework.http.ResponseEntity;

import com.dhirajb7.moviecatalogservice.entity.Catalog;

public interface CatalogServiceInterface {
	
	ResponseEntity<Object> getCatalogDetailsForUserId(String userId);
	
	ResponseEntity<Object> addCatalogForUser(Catalog catalog);
	
	
}
