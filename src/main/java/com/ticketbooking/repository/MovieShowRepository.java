package com.ticketbooking.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticketbooking.entities.MovieShow;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer>, JpaSpecificationExecutor<MovieShow> {

    @Query(value = "SELECT * FROM movie_show WHERE startDate <= ?1 AND endDate >= ?1", nativeQuery = true)
    List<MovieShow> findByDate(String date);

    @Query(value = "SELECT * FROM movie_show WHERE startDate <= CURRENT_DATE AND endDate >= CURRENT_DATE", nativeQuery = true)
    List<MovieShow> todaysShow();

    List<MovieShow> findAll(Specification<MovieShow> spec);
}
