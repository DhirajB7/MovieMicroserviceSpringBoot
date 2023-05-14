package com.dhirajb7.moviecatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhirajb7.moviecatalogservice.entity.Catalog;

public interface CatalogRepo extends JpaRepository<Catalog, String>{

}
