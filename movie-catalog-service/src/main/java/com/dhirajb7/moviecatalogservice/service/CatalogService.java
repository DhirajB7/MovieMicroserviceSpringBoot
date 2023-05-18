package com.dhirajb7.moviecatalogservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.dhirajb7.moviecatalogservice.entity.Catalog;
import com.dhirajb7.moviecatalogservice.pojo.helper.MessageHolder;
import com.dhirajb7.moviecatalogservice.pojo.helper.Movie;
import com.dhirajb7.moviecatalogservice.pojo.helper.MovieDetails;
import com.dhirajb7.moviecatalogservice.pojo.helper.Rating;
import com.dhirajb7.moviecatalogservice.pojo.helper.User;
import com.dhirajb7.moviecatalogservice.pojo.response.AddCatalogResponse;
import com.dhirajb7.moviecatalogservice.repository.CatalogRepo;

@Service
public class CatalogService implements CatalogServiceInterface {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CatalogRepo catalogRepo;

	@Override
	public ResponseEntity<Object> getCatalogDetailsForUserId(String userId) {

		Object object = null;

		HttpStatus httpStatus = null;

		if (catalogRepo.existsById(userId)) {

			List<String> movieIds = catalogRepo.findById(userId).get().getMovieIds();

			List<MovieDetails> listOfMovieDetails = new ArrayList<MovieDetails>();

			try {

				movieIds.forEach(oneMovieId -> {

					ResponseEntity<Movie> movieObject = restTemplate
							.getForEntity("http://localhost:8082/movie/" + oneMovieId, Movie.class);

					ResponseEntity<Rating> ratingObject = restTemplate
							.getForEntity("http://localhost:8083/rating/" + oneMovieId, Rating.class);

				});
			} catch (HttpClientErrorException e) {

				object = e.getResponseBodyAs(MessageHolder.class);

				httpStatus = HttpStatus.resolve(e.getStatusCode().value());

			}

		} else {

			object = new MessageHolder("USER ID NOT FOUND");

			httpStatus = HttpStatus.NOT_FOUND;
		}

		return new ResponseEntity<Object>(catalogRepo.findById(userId), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Object> addCatalogForUser(Catalog catalog) {

		Object object = null;

		HttpStatus httpStatus = null;

		String userId = catalog.getUserId();

		try {

			ResponseEntity<User> user = restTemplate.getForEntity("http://localhost:8084/user/" + userId, User.class);

			if (catalogRepo.existsById(userId)) {

				List<String> movieIds = catalogRepo.findById(userId).get().getMovieIds();

				movieIds.addAll(catalog.getMovieIds());

				movieIds = movieIds.stream().distinct().toList();

				catalogRepo.deleteById(userId);

				Catalog addedCatalogToDB = catalogRepo.save(new Catalog(userId, movieIds));

				object = new AddCatalogResponse(user.getBody().getFirstName(), user.getBody().getLastName(),
						user.getBody().getEmail(), addedCatalogToDB.getMovieIds());

				httpStatus = HttpStatus.OK;

			} else {

				if (user.getStatusCode().is2xxSuccessful()) {

					Catalog addedCatalogToDB = catalogRepo.save(catalog);

					object = new AddCatalogResponse(user.getBody().getFirstName(), user.getBody().getLastName(),
							user.getBody().getEmail(), addedCatalogToDB.getMovieIds());

					httpStatus = HttpStatus.CREATED;

				} else {

					object = new MessageHolder("Contact admin as HTTP response is not 2xx.");

					httpStatus = HttpStatus.resolve(user.getStatusCode().value());

				}
			}

		} catch (HttpClientErrorException e) {

			object = e.getResponseBodyAs(MessageHolder.class);

			httpStatus = HttpStatus.resolve(e.getStatusCode().value());

		}

		return new ResponseEntity<Object>(object, httpStatus);

	}

}