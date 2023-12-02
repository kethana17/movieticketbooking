package com.hexaware.movieticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.movieticketbooking.dto.SeatingDTO;
import com.hexaware.movieticketbooking.service.ISeatingService;

import java.util.List;

@RestController
@RequestMapping("/api/seating")
public class SeatingRestController {

    @Autowired
    private ISeatingService seatingService;

    @GetMapping("/availableSeats")
    public ResponseEntity<List<SeatingDTO>> getAllAvailableSeats() {
        List<SeatingDTO> availableSeats = seatingService.getAllAvailableSeats();
        return new ResponseEntity<>(availableSeats, HttpStatus.OK);
    }
}
