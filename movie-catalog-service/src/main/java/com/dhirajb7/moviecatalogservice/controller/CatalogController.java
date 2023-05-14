package com.dhirajb7.moviecatalogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dhirajb7.moviecatalogservice.service.CatalogService;


@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private CatalogService catalogService;
    
    @GetMapping
    public ResponseEntity<Object> getAllCatalog(){
    	return catalogService.getAllCatalogs();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getCatalogForUser(@PathVariable("userId") String userId){
    	return catalogService.getCatalogForUserId(userId);
    }

}
