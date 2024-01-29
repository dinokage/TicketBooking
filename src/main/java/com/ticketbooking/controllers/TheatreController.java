package com.ticketbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.dto.SeatDTO;
import com.ticketbooking.dto.TheatreDTO;
import com.ticketbooking.services.TheatreService;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/seats")
    public ResponseEntity<?> saveTheatreSeats(@RequestBody SeatDTO seatDTO) {
        theatreService.saveSeat(seatDTO);
        return ResponseEntity.ok().body("Theatre seats capacity saved successfully");
    }

    @DeleteMapping("/seats/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable("id") int id) {
        theatreService.deleteSeat(id);
        return ResponseEntity.ok("Seat deleted successfully");
    }

    @PostMapping
    public ResponseEntity<?> saveTheatre(@RequestBody TheatreDTO theatreDTO) {
        theatreService.saveTheatre(theatreDTO);
        return ResponseEntity.ok().body("Theatre saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listAllTheatres() {
        return ResponseEntity.ok(theatreService.listAllTheatres());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheatre(@PathVariable("id") int id) {
        theatreService.deleteTheatre(id);
        return ResponseEntity.ok("Theatre deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTheatreDetails(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(theatreService.findTheatreById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTheatre(@RequestBody TheatreDTO theatreDTO) {
        theatreService.updateTheatre(theatreDTO);
        return ResponseEntity.ok("Theatre updated successfully");
    }
}
