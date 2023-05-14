package com.dhirajb7.movieinfoservice.service;

import org.springframework.http.ResponseEntity;

import com.dhirajb7.movieinfoservice.entity.Movie;

interface MovieServiceInterface {
	
	ResponseEntity<Object> getMovieByMovieId(String movieId);
	
	ResponseEntity<Object> addMovie(Movie movieData);
	
	ResponseEntity<Object> gettAllMovies();
	
	ResponseEntity<Object> editAMovie(Movie movieData);
	
	ResponseEntity<Object> deleteAMovie(String movieId);
	
	

}
