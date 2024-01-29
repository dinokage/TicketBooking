package com.ticketbooking.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;

    @Column(nullable = false)
    private String theatreName;

    @Column(nullable = false)
    private String theatreCity;
    
    @Column(nullable = false)
    private int theatreCapacity;

	/*
	 * @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL) private
	 * List<Movie> listOfMovies;
	 */

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Seat> Seat;

    @Column(nullable = false)
    private String managerName;

    @Column(nullable = false)
    private String managerContact;

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public int getTheatreCapacity() {
		return theatreCapacity;
	}

	public void setTheatreCapacity(int theatreCapacity) {
		this.theatreCapacity = theatreCapacity;
	}

	public List<Seat> getSeat() {
		return Seat;
	}

	public void setSeat(List<Seat> seat) {
		Seat = seat;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	

	public Theatre() {
    	
    }

	public Theatre(int theatreId, String theatreName, String theatreCity, List<com.ticketbooking.entities.Seat> seat,
			String managerName, String managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		Seat = seat;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public Theatre(String theatreName, String theatreCity, int theatreCapacity, String managerName,
			String managerContact) {
		super();
		this.theatreName = theatreName;
		this.theatreCity = theatreCity;
		this.theatreCapacity = theatreCapacity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	

	
	
	
    
}
