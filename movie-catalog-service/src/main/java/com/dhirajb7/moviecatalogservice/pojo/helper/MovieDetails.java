package com.dhirajb7.moviecatalogservice.pojo.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetails {

	private String movieId;
	
	private String movieName;
	
	private String movieDescription;
	
	private int movieRating;

}
