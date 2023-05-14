package com.dhirajb7.ratingsdataservice.service;

import org.springframework.http.ResponseEntity;

import com.dhirajb7.ratingsdataservice.entity.Rating;

interface RatingServiceInterface {
	
	ResponseEntity<Object> getRatingByMovieId(String movieId);
	
	ResponseEntity<Object> addRating(Rating ratingData);
	
	ResponseEntity<Object> gettAllRatings();
	
	ResponseEntity<Object> editARating(Rating ratingData);
	
	ResponseEntity<Object> deleteARating(String movieId);

}
