package com.dhirajb7.moviecatalogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhirajb7.moviecatalogservice.entity.Catalog;
import com.dhirajb7.moviecatalogservice.service.CatalogService;


@RestController
@RequestMapping("/catalog")
public class CatalogController {
    
    @Autowired
    private CatalogService catalogService;
    
    @PostMapping
    public ResponseEntity<Object> addCatalog(@RequestBody Catalog catalog){
    	return catalogService.addCatalogForUser(catalog);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getCatalogForUser(@PathVariable("userId") String userId){
    	return catalogService.getCatalogDetailsForUserId(userId);
    }

}
