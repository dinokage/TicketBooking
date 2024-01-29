package com.ticketbooking.dto;

public class SeatDTO {

    private int seatId;
    private int seatCount;
    private int theatreId; // ID of the associated Theatre
    private int seatTypeId;

    public SeatDTO() {
        // Default constructor
    }

    public SeatDTO(int seatId, int seatCount, int theatreId) {
        this.seatId = seatId;
        this.seatCount = seatCount;
        this.theatreId = theatreId;
    }

    // Getters and setters for all fields

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
}
