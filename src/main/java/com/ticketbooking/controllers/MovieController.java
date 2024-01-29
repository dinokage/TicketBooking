package com.ticketbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.dto.MovieDTO;
import com.ticketbooking.entities.Movie;
import com.ticketbooking.services.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody MovieDTO movieDTO) {
        Movie movie = movieService.convertToEntity(movieDTO);
        movieService.save(movie);
        return ResponseEntity.ok().body("Movie saved successfully");
    }

    @GetMapping
    public ResponseEntity<List<MovieDTO>> listAllMovies() {
        List<MovieDTO> movieDTOs = movieService.listAll();
        return ResponseEntity.ok(movieDTOs);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") int id) {
        if (!(movieService.findById(id).equals(null))) {
            movieService.deleteMovie(id);
            return ResponseEntity.ok("Movie deleted successfully");
        }  
        return ResponseEntity.badRequest().body("not "); 

    }
    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> findMovieDetails(@PathVariable("id") int id) {
        MovieDTO movieDTO = movieService.findById(id);
        return ResponseEntity.ok(movieDTO);
    }
}
