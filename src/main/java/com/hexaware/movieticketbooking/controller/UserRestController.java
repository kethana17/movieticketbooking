package com.hexaware.movieticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexaware.movieticketbooking.dto.BookingRequestDTO;
import com.hexaware.movieticketbooking.dto.SeatingDTO;
import com.hexaware.movieticketbooking.dto.UserDTO;
import com.hexaware.movieticketbooking.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int userId) {
        UserDTO userDTO = userService.getUserDTOById(userId);
        if (userDTO != null) {
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userId}/bookSeat")
    public ResponseEntity<SeatingDTO> bookSeat(
            @PathVariable int userId,
            @RequestBody BookingRequestDTO bookingRequestDTO) {
        try {
            SeatingDTO bookedSeatDTO = userService.bookSeat(userId, bookingRequestDTO);
            return new ResponseEntity<>(bookedSeatDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}