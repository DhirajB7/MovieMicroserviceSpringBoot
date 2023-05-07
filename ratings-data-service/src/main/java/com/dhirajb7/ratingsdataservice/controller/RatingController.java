package com.dhirajb7.ratingsdataservice.controller;

import com.dhirajb7.ratingsdataservice.entity.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getRatingByMovieId(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

}
