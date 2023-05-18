package com.dhirajb7.movieinfoservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dhirajb7.movieinfoservice.entity.Movie;
import com.dhirajb7.movieinfoservice.pojo.MessageHolder;
import com.dhirajb7.movieinfoservice.repository.MovieRepo;

@Service
public class MovieService implements MovieServiceInterface {

	@Autowired
	private MovieRepo movieRepo;

	@Override
	public ResponseEntity<Object> getMovieByMovieId(String movieId) {

		Object object = null;

		HttpStatus status = null;

		if (movieRepo.existsById(movieId)) {

			object = movieRepo.findById(movieId);

			status = HttpStatus.OK;

		} else {

			object = new MessageHolder(movieId + " NOT FOUND");

			status = HttpStatus.NOT_FOUND;

		}

		return new ResponseEntity<Object>(object, status);

	}

	@Override
	public ResponseEntity<Object> addMovie(Movie movieData) {

		Object object = null;

		HttpStatus status = null;

		if (movieRepo.existsById(movieData.getMovieId())) {

			object = new MessageHolder("MOVIE DATA PRESENT");

			status = HttpStatus.CONFLICT;

		} else {

			object = movieRepo.save(movieData);

			status = HttpStatus.CREATED;

		}

		return new ResponseEntity<Object>(object, status);
	}

	@Override
	public ResponseEntity<Object> gettAllMovies() {

		return new ResponseEntity<Object>(movieRepo.findAll(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> editAMovie(Movie movieData) {

		Object object = null;

		HttpStatus status = null;

		if (movieRepo.existsById(movieData.getMovieId())) {

			movieRepo.deleteById(movieData.getMovieId());
			
			object = movieRepo.save(movieData);

			status = HttpStatus.OK;

		} else {

			object = movieRepo.save(movieData);

			status = HttpStatus.CREATED;

		}

		return new ResponseEntity<Object>(object, status);

	}

	@Override
	public ResponseEntity<Object> deleteAMovie(String movieId) {
		
		Object object = null;

		HttpStatus status = null;

		if (movieRepo.existsById(movieId)) {

			movieRepo.deleteById(movieId);

			object = new MessageHolder("MOVIE DELETED");

			status = HttpStatus.OK;

		} else {

			object = new MessageHolder(movieId + " NOT FOUND");

			status = HttpStatus.NOT_FOUND;

		}

		return new ResponseEntity<Object>(object, status);
	}

}
