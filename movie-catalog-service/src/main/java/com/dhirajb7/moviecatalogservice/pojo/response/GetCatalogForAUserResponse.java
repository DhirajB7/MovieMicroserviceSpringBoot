package com.dhirajb7.moviecatalogservice.pojo.response;

import java.util.List;

import com.dhirajb7.moviecatalogservice.pojo.helper.MovieDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetCatalogForAUserResponse {

	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String age;
	
	private List<MovieDetails> movieDetails;

}
