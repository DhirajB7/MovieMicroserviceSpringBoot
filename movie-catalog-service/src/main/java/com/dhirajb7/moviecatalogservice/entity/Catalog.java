package com.dhirajb7.moviecatalogservice.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {

	@Id
	private String userId;
	@ElementCollection
	@CollectionTable(name = "MOVIE_IDS",joinColumns = @JoinColumn(name = "user_id"))
    private List<String> movieIds;

}
