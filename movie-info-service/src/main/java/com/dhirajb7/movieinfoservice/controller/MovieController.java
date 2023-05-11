package com.dhirajb7.movieinfoservice.controller;

import com.dhirajb7.movieinfoservice.entity.Movie;
import com.dhirajb7.movieinfoservice.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@GetMapping
	public ResponseEntity<Object> getAllMovies(){
		return movieService.gettAllMovies();
	}
	
	@PostMapping
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie){
		return movieService.addMovie(movie);
	}
	
    @GetMapping("/{movieId}")
    public ResponseEntity<Object> getMovieDetail(@PathVariable("movieId") String movieId) {
       return movieService.getMovieByMovieId(movieId);
    }
    
    @PutMapping
	public ResponseEntity<Object> editOrAddMovie(@RequestBody Movie movie){
		return movieService.editAMovie(movie);
	}
	
    @DeleteMapping("/{movieId}")
    public ResponseEntity<Object> deleteMovieById(@PathVariable("movieId") String movieId) {
       return movieService.deleteAMovie(movieId);
    }
    
}
