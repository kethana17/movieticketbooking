package com.hexaware.movieticketbooking.service;

import com.hexaware.movieticketbooking.dto.BookingRequestDTO;
import com.hexaware.movieticketbooking.dto.SeatingDTO;
import com.hexaware.movieticketbooking.dto.UserDTO;

public interface IUserService {
    UserDTO getUserDTOById(int userId);

    SeatingDTO bookSeat(int userId, BookingRequestDTO bookingRequestDTO) throws Exception;
}