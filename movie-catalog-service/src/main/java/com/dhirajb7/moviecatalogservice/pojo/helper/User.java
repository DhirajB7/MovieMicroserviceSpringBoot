package com.dhirajb7.moviecatalogservice.pojo.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private String userId;
	private String email;
	private String firstName;
	private String lastName;
	private int age;
	private long phone;
	
}