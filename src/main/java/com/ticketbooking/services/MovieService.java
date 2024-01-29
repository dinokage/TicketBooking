package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.dto.MovieDTO;
import com.ticketbooking.entities.Movie;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface MovieService {

	Movie convertToEntity(MovieDTO movieDTO)throws InvalidEntityException;
	
    void save(Movie movie)throws InvalidEntityException;

    List<MovieDTO> listAll()throws InvalidEntityException;

    MovieDTO findById(int id)throws InvalidEntityException;

    void deleteMovie(int id)throws InvalidEntityException;
}
