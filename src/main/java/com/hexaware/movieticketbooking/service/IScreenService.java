package com.hexaware.movieticketbooking.service;

import java.util.List;
import com.hexaware.movieticketbooking.dto.ScreenDTO;

public interface IScreenService {
    ScreenDTO addScreen(ScreenDTO screenDTO, int theatreId);
    void removeScreen(int screenId);
    List<ScreenDTO> getAllScreens();
    List<ScreenDTO> getScreensByTheatre(int theatreId);
}