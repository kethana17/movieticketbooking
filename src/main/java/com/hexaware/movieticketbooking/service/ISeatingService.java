package com.hexaware.movieticketbooking.service;

import java.util.List;

import com.hexaware.movieticketbooking.dto.SeatingDTO;

	public interface ISeatingService {
	    List<SeatingDTO> getAllAvailableSeats();
	}
