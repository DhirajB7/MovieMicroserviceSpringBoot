package com.dhirajb7.ratingsdataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhirajb7.ratingsdataservice.entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, String> {

}
