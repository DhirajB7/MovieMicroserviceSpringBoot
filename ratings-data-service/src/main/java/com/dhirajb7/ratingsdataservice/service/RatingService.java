package com.dhirajb7.ratingsdataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhirajb7.ratingsdataservice.entity.Rating;
import com.dhirajb7.ratingsdataservice.pojo.MessageHolder;
import com.dhirajb7.ratingsdataservice.repository.RatingRepo;

@Service
public class RatingService implements RatingServiceInterface {

	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public ResponseEntity<Object> getRatingByMovieId(String movieId) {

		Object object = null;

		HttpStatus status = null;

		if (ratingRepo.existsById(movieId)) {

			object = ratingRepo.findById(movieId);

			status = HttpStatus.OK;

		} else {

			object = new MessageHolder(movieId+" NOT FOUND");

			status = HttpStatus.NOT_FOUND;

		}

		return new ResponseEntity<Object>(object, status);
	}

	@Override
	public ResponseEntity<Object> addRating(Rating ratingData) {

		Object object = null;

		HttpStatus status = null;

		if (ratingRepo.existsById(ratingData.getMovieId())) {

			object = new MessageHolder("RATING DATA PRESENT");

			status = HttpStatus.CONFLICT;

		} else {

			object = ratingRepo.save(ratingData);

			status = HttpStatus.CREATED;

		}

		return new ResponseEntity<Object>(object, status);
	}

	@Override
	public ResponseEntity<Object> gettAllRatings() {

		return new ResponseEntity<>(ratingRepo.findAll(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> editARating(Rating ratingData) {
		
		Object object = null;

		HttpStatus status = null;

		if (ratingRepo.existsById(ratingData.getMovieId())) {

			ratingRepo.deleteById(ratingData.getMovieId());
			
			object = ratingRepo.save(ratingData);

			status = HttpStatus.OK;

		} else {

			object = ratingRepo.save(ratingData);

			status = HttpStatus.CREATED;

		}

		return new ResponseEntity<Object>(object, status);
		
	}

	@Override
	public ResponseEntity<Object> deleteARating(String movieId) {

		Object object = null;

		HttpStatus status = null;

		if (ratingRepo.existsById(movieId)) {

			ratingRepo.deleteById(movieId);

			object = new MessageHolder("RATING DELETED");

			status = HttpStatus.OK;

		} else {

			object = new MessageHolder(movieId+" NOT FOUND");

			status = HttpStatus.NOT_FOUND;

		}

		return new ResponseEntity<Object>(object, status);
	
	}

}
