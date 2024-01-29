package com.ticketbooking.services;

import java.util.List;

import com.ticketbooking.dto.SeatDTO;
import com.ticketbooking.dto.TheatreDTO;
import com.ticketbooking.globalexception.InvalidEntityException;

public interface TheatreService {

    void saveSeat(SeatDTO seatDTO) throws InvalidEntityException;

    void deleteSeat(int id) throws InvalidEntityException;

    void saveTheatre(TheatreDTO theatreDTO) throws InvalidEntityException;

    List<TheatreDTO> listAllTheatres() throws InvalidEntityException;

    TheatreDTO findTheatreById(int id) throws InvalidEntityException;

    void updateTheatre(TheatreDTO theatreDTO) throws InvalidEntityException;

    void deleteTheatre(int id) throws InvalidEntityException;
}
