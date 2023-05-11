package com.dhirajb7.movieinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dhirajb7.movieinfoservice.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, String> {

}
