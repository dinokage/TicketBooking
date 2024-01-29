package com.ticketbooking.entities;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MovieShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieShowId;

    @Column(nullable = false)
    private LocalDate movieShowStartDate;
    private LocalDate movieShowEndDate;
    private int slot;
	private int price;
	
    @ManyToOne
    @JoinColumn(name = "theatre_id") 
    private Theatre theatre;

	/*
	 * @Column(nullable = false) private String movieShowName;
	 * 
	 * @OneToMany(mappedBy = "movieShow", cascade = CascadeType.ALL) private
	 * List<Booking> bookingList;
	 * 
	 * @OneToMany(mappedBy = "movieShow") 
	 * private List<Ticket> tickets;
	 */

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

	public MovieShow() {
		super();
	}



	public MovieShow(int movieShowId, LocalDate movieShowStartDate, LocalDate movieShowEndDate, int slot, int price,
			Theatre theatre, Movie movie) {
		super();
		this.movieShowId = movieShowId;
		this.movieShowStartDate = movieShowStartDate;
		this.movieShowEndDate = movieShowEndDate;
		this.slot = slot;
		this.price = price;
		this.theatre = theatre;
		this.movie = movie;
	}
	
	public MovieShow(LocalDate movieShowStartDate, LocalDate movieShowEndDate, int slot, int price,
			Theatre theatre, Movie movie) {
		super();
		this.movieShowStartDate = movieShowStartDate;
		this.movieShowEndDate = movieShowEndDate;
		this.slot = slot;
		this.price = price;
		this.theatre = theatre;
		this.movie = movie;
	}



	public int getMovieShowId() {
		return movieShowId;
	}

	public void setMovieShowId(int movieShowId) {
		this.movieShowId = movieShowId;
	}

	public LocalDate getMovieShowStartDate() {
		return movieShowStartDate;
	}

	public void setMovieShowStartDate(LocalDate movieShowStartDate) {
		this.movieShowStartDate = movieShowStartDate;
	}

	public LocalDate getMovieShowEndDate() {
		return movieShowEndDate;
	}

	public void setMovieShowEndDate(LocalDate movieShowEndDate) {
		this.movieShowEndDate = movieShowEndDate;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
    
}

