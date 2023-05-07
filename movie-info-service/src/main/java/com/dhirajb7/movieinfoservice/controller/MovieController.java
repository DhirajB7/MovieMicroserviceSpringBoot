package com.dhirajb7.movieinfoservice.controller;

import com.dhirajb7.movieinfoservice.entity.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @GetMapping("/{movieId}")
    public Movie getMovieDetail(@PathVariable("movieId") String movieId) {

        return new Movie(movieId, "movie name");

    }

}
