package com.dimaspriyo.springbootmoviecrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dimaspriyo.springbootmoviecrud.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

	
	
	
}
