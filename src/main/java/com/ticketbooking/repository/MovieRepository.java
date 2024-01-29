package com.ticketbooking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{
	// Find a movie by ID
    Movie findById(int movieId);

}
