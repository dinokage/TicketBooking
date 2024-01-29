package com.ticketbooking.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.ticketbooking.dto.MovieShowDTO;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface MovieShowService {

    void save(MovieShow movieShow) throws InvalidEntityException;

    List<MovieShowDTO> listAll() throws InvalidEntityException;

    List<MovieShowDTO> todayShows() throws InvalidEntityException;

    MovieShowDTO findById(int id) throws InvalidEntityException;

    void deleteMovieShow(int id) throws InvalidEntityException;

    List<MovieShowDTO> findByDate(String date) throws InvalidEntityException;

    List<MovieShowDTO> findAllWithSpec(Specification<MovieShow> spec) throws InvalidEntityException;
}
