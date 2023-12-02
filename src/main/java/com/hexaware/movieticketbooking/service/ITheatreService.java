package com.hexaware.movieticketbooking.service;

import java.util.List;
import com.hexaware.movieticketbooking.dto.TheatreDTO;
import com.hexaware.movieticketbooking.entity.Theatre;

public interface ITheatreService {

    TheatreDTO addTheatre(TheatreDTO theatreDTO);

    void removeTheatre(int theatreId);

    Theatre getTheatreByName(String name);

    List<TheatreDTO> getAllTheatres();
}