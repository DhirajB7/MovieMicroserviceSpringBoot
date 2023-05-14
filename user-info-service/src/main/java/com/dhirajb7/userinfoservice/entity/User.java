package com.dhirajb7.userinfoservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS") //User is keyWord so DB won't be created
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	private String userId;
	private String email;
	private String firstName;
	private String lastName;
	private int age;
	private long phone;
}
