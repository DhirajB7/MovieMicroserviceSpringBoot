package com.dhirajb7.moviecatalogservice.pojo.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCatalogResponse {
	
	private String firstName;
	private String lastName;
	private String email;
	private List<String> movieIds;
	
}
