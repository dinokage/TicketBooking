package com.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ticketbooking.entities.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer>{

}
