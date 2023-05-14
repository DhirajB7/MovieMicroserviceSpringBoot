package com.dhirajb7.moviecatalogservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dhirajb7.moviecatalogservice.pojo.Catalog;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<Catalog> getCatalogForUser(@PathVariable("userId") String userId){

        List<Catalog> moviesCatalog = new ArrayList<>();

        restTemplate.getForObject("",String.class);

        moviesCatalog.add(new Catalog("Don't Worry Darling","Psyco + thiller + kinda horror",3));
        moviesCatalog.add(new Catalog("Guardians Of Galaxy","BEST GOG EVER",5));
        moviesCatalog.add(new Catalog("Antman and Wasp Quantiamania","sifi + really good movie",4));

        return moviesCatalog;
    }

}
