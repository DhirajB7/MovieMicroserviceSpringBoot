package com.dhirajb7.ratingsdataservice.service;

import org.springframework.http.ResponseEntity;

import com.dhirajb7.ratingsdataservice.entity.Rating;

public interface RatingServiceInterface {
	
	public ResponseEntity<Object> getRatingByMovieId(String movieId);
	
	public ResponseEntity<Object> addRating(Rating ratingData);
	
	public ResponseEntity<Object> gettAllRatings();
	
	public ResponseEntity<Object> editARating(Rating ratingData);
	
	public ResponseEntity<Object> deleteARating(String movieId);

}
