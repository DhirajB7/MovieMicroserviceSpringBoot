package com.dhirajb7.moviecatalogservice.controller;

import com.dhirajb7.moviecatalogservice.entity.MovieCatalogEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @GetMapping("/{userId}")
    public List<MovieCatalogEntity> getCatalogForUser(@PathVariable("userId") String userId){

        List<MovieCatalogEntity> moviesCatalog = new ArrayList<>();

        moviesCatalog.add(new MovieCatalogEntity("Don't Worry Darling","Psyco + thiller + kinda horror",3));
        moviesCatalog.add(new MovieCatalogEntity("Guardians Of Galaxy","BEST GOG EVER",5));
        moviesCatalog.add(new MovieCatalogEntity("Antman and Wasp Quantiamania","sifi + really good movie",4));

        return moviesCatalog;
    }

}
