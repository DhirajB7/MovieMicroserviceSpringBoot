package com.dhirajb7.movieinfoservice.service;

import org.springframework.http.ResponseEntity;

import com.dhirajb7.movieinfoservice.entity.Movie;

public interface MovieServiceInterface {
	
	public ResponseEntity<Object> getMovieByMovieId(String movieId);
	
	public ResponseEntity<Object> addMovie(Movie movieData);
	
	public ResponseEntity<Object> gettAllMovies();
	
	public ResponseEntity<Object> editAMovie(Movie movieData);
	
	public ResponseEntity<Object> deleteAMovie(String movieId);
	
	

}
