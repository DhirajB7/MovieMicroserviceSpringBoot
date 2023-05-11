package com.dhirajb7.ratingsdataservice.controller;

import com.dhirajb7.ratingsdataservice.entity.Rating;
import com.dhirajb7.ratingsdataservice.service.RatingService;

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
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@GetMapping
	public ResponseEntity<Object> getAllRatings() {
		return ratingService.gettAllRatings();
	}

	@GetMapping("/{movieId}")
	public ResponseEntity<Object> getRatingByMovieId(@PathVariable("movieId") String movieId) {
		return ratingService.getRatingByMovieId(movieId);
	}
	
	@PostMapping
	public ResponseEntity<Object> addRating(@RequestBody Rating ratingData) {
		return ratingService.addRating(ratingData);
	}
	
	@DeleteMapping("/{movieId}")
	public ResponseEntity<Object> deleteRatingByMovieId(@PathVariable("movieId") String movieId) {
		return ratingService.deleteARating(movieId);
	}
	
	@PutMapping
	public ResponseEntity<Object> editRating(@RequestBody Rating ratingData) {
		return ratingService.editARating(ratingData);
	}
	
	

}
