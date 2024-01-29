package com.ticketbooking.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticketbooking.dto.MovieDTO;
import com.ticketbooking.entities.Movie;
import com.ticketbooking.repository.MovieRepository;

import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<MovieDTO> listAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movie -> modelMapper.map(movie, MovieDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO findById(int id) {
        Movie movie = movieRepository.getById(id);
        return modelMapper.map(movie, MovieDTO.class);
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.delete(movieRepository.getById(id));
    }

    @Override
    public Movie convertToEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }
}
