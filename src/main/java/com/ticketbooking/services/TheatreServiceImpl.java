package com.ticketbooking.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.dto.SeatDTO;
import com.ticketbooking.dto.TheatreDTO;
import com.ticketbooking.entities.Seat;
import com.ticketbooking.entities.Theatre;
import com.ticketbooking.repository.TheatreRepository;
import com.ticketbooking.repository.SeatRepository;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final SeatRepository seatRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TheatreServiceImpl(
            TheatreRepository theatreRepository,
            SeatRepository seatRepository,
            ModelMapper modelMapper) {
        this.theatreRepository = theatreRepository;
        this.seatRepository = seatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveSeat(SeatDTO seatDTO) {
        // Implementation using the injected dependencies.
        Seat seat = modelMapper.map(seatDTO, Seat.class);
        seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(int id) {
        // Implementation using the injected dependencies.
        seatRepository.deleteById(id);
    }

    @Override
    public void saveTheatre(TheatreDTO theatreDTO) {
        // Implementation using the injected dependencies.
        Theatre theatre = modelMapper.map(theatreDTO, Theatre.class);
        theatreRepository.save(theatre);
    }

    @Override
    public List<TheatreDTO> listAllTheatres() {
        List<Theatre> theatres = theatreRepository.findAll();
        return theatres.stream()
                .map(theatre -> modelMapper.map(theatre, TheatreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TheatreDTO findTheatreById(int id) {
        Theatre theatre = theatreRepository.getById(id);
        return modelMapper.map(theatre, TheatreDTO.class);
    }

    @Override
    public void deleteTheatre(int id) {
        theatreRepository.deleteById(id);
    }
    @Override
    public void updateTheatre(TheatreDTO theatreDTO) {
        Theatre existingTheatre = theatreRepository.findById(theatreDTO.getTheatreId())
                .orElseThrow(() -> new RuntimeException("Theatre not found with id: " + theatreDTO.getTheatreId()));

        // Update the existing theatre with new values from the DTO
        modelMapper.map(theatreDTO, existingTheatre);

        // Save the updated theatre
        theatreRepository.save(existingTheatre);
    }

}
