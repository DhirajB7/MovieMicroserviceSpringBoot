package com.dhirajb7.moviecatalogservice.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="catalogs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {

	@Id
	@Column(name = "user_id")
	private String userId;
	@ElementCollection
//	@CollectionTable(name = "movie_ids",joinColumns = @JoinColumn(name = "user_id"))
    private List<String> movieIds;

}
