package com.ticketbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ticketbooking.entities.Booking;
import com.ticketbooking.dto.BookingDTO;  
import com.ticketbooking.services.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(@Qualifier("bookingServiceImpl") BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> saveBooking(@RequestBody Booking booking) {
        bookingService.save(booking);
        return ResponseEntity.ok().body("Booking saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> listAllBookings(@RequestParam(value = "userid", required = false) Integer userid) {
        if (userid != null) {
            List<BookingDTO> userBookings = bookingService.allUserBookingList(userid);
            return ResponseEntity.ok(userBookings);
        } else {
            List<BookingDTO> allBookings = bookingService.getBookingList();
            return ResponseEntity.ok(allBookings);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable("id") int id) {
        bookingService.delete(id);
        return ResponseEntity.ok("Booking canceled successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findBookingDetails(@PathVariable("id") int id) {
        BookingDTO bookingDTO = bookingService.findById(id);
        return ResponseEntity.ok(bookingDTO);
    }
}
