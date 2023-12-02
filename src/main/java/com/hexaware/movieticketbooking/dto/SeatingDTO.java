package com.hexaware.movieticketbooking.dto;

public class SeatingDTO {
	
	private int seatingId;
    private int seatNumber;
    private double seatCost;
    private boolean booked;
    
	public SeatingDTO(int seatingId, int seatNumber, double seatCost, boolean booked) {
		super();
		this.seatingId = seatingId;
		this.seatNumber = seatNumber;
		this.seatCost = seatCost;
		this.booked = booked;
	}

	public SeatingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSeatingId() {
		return seatingId;
	}
	public void setSeatingId(int seatingId) {
		this.seatingId = seatingId;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getSeatCost() {
		return seatCost;
	}
	public void setSeatCost(double seatCost) {
		this.seatCost = seatCost;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}


}
