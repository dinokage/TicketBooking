package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.dto.MovieShowCheckDTO;
import com.ticketbooking.dto.BookingDTO;  // Import the BookingDTO
import com.ticketbooking.entities.Booking;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface BookingService {

    BookingDTO findById(int id) throws InvalidEntityException;

    void save(Booking booking)throws InvalidEntityException;

    List<BookingDTO> getBookingList()throws InvalidEntityException;

    List<BookingDTO> allUserBookingList(int id)throws InvalidEntityException;

    List<BookingDTO> allOccupiedBookingList(MovieShowCheckDTO dto)throws InvalidEntityException;

    void delete(int id)throws InvalidEntityException;
}
