package com.ticketbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ticketbooking.entities.MovieShow;
import com.ticketbooking.services.MovieShowService;

@RestController
@RequestMapping("/api/movieShows")
public class MovieShowController {

    @Autowired
    private MovieShowService movieShowService;

    @PostMapping
    public ResponseEntity<?> saveMovieShow(@RequestBody MovieShow movieShow) {
        movieShowService.save(movieShow);
        return ResponseEntity.ok().body("Movie show saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listAllMovieShows() {
        return ResponseEntity.ok(movieShowService.listAll());
    }

    @GetMapping("todays")
    public ResponseEntity<?> todayMovieShows() {
        return ResponseEntity.ok(movieShowService.todayShows());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteMovieShow(@PathVariable("id") int id) {
        movieShowService.deleteMovieShow(id);
        return ResponseEntity.ok("Movie show deleted successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findMovieShowDetails(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(movieShowService.findById(id));
    }
}
