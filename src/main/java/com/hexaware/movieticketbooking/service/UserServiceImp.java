package com.hexaware.movieticketbooking.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hexaware.movieticketbooking.entity.Seating;
import com.hexaware.movieticketbooking.entity.User;
import com.hexaware.movieticketbooking.dto.BookingRequestDTO;
import com.hexaware.movieticketbooking.dto.SeatingDTO;
import com.hexaware.movieticketbooking.dto.UserDTO;
import com.hexaware.movieticketbooking.repository.SeatingRepository;
import com.hexaware.movieticketbooking.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {
	
	private  PasswordEncoder passwordEncoder;	

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatingRepository seatingRepository;
    
    public UserServiceImp(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}
	 private final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public UserDTO getUserDTOById(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return convertToUserDTO(user);
        }
        return null;
    }

    @Override
    public SeatingDTO bookSeat(int userId, BookingRequestDTO bookingRequestDTO) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));

        Seating seat = seatingRepository.findById(bookingRequestDTO.getSeatId())
                .orElseThrow(() -> new Exception("Seat not found"));

        if (seat.isBooked()) {
            throw new Exception("Seat already booked");
        }

        seat.setBooked(true);
        seat.setUser(user);
        seatingRepository.save(seat);

        return convertToSeatingDTO(seat);
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUsername(user.getUsername());
        userDTO.setBookedSeats(convertToSeatingDTOList(user.getBookedSeats()));
        return userDTO;
    }

    private List<SeatingDTO> convertToSeatingDTOList(List<Seating> seatingList) {
        return seatingList.stream()
                .map(this::convertToSeatingDTO)
                .collect(Collectors.toList());
    }

    private SeatingDTO convertToSeatingDTO(Seating seating) {
        SeatingDTO seatingDTO = new SeatingDTO();
        seatingDTO.setSeatingId(seating.getSeatingId());
        seatingDTO.setSeatNumber(seating.getSeatNumber());
        seatingDTO.setSeatCost(seating.getSeatCost());
        seatingDTO.setBooked(seating.isBooked());
        return seatingDTO;
    }
}