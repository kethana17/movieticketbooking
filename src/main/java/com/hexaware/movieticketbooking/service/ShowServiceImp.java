package com.hexaware.movieticketbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.movieticketbooking.dto.ShowDTO;
import com.hexaware.movieticketbooking.entity.Movie;
import com.hexaware.movieticketbooking.entity.Screen;
import com.hexaware.movieticketbooking.entity.Show;
import com.hexaware.movieticketbooking.entity.Theatre;
import com.hexaware.movieticketbooking.repository.MovieRepository;
import com.hexaware.movieticketbooking.repository.ScreenRepository;
import com.hexaware.movieticketbooking.repository.ShowRepository;
import com.hexaware.movieticketbooking.repository.TheatreRepository;


@Service
public class ShowServiceImp implements IShowService {

    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ScreenRepository screenRepository;
    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public ShowDTO addShow(ShowDTO showDTO) {
        Show newShow = new Show();
        newShow.setShowName(showDTO.getShowName());
        newShow.setShowTime(showDTO.getShowTime());

        // Assuming you have methods to retrieve Theatre, Screen, and Movie entities
        Theatre theatre = getTheatreById(showDTO.getTheatreId());
        Screen screen = getScreenById(showDTO.getScreenId());
        Movie movie = getMovieById(showDTO.getMovieId());

        if (theatre != null && screen != null && movie != null) {
            newShow.setTheatre(theatre);
            newShow.setScreen(screen);
            newShow.setMovie(movie);

            Show savedShow = showRepository.save(newShow);

            ShowDTO savedShowDTO = new ShowDTO();
            savedShowDTO.setShowId(savedShow.getShowId());
            savedShowDTO.setShowName(savedShow.getShowName());
            savedShowDTO.setShowTime(savedShow.getShowTime());
            savedShowDTO.setTheatreId(savedShow.getTheatre().getId());
            savedShowDTO.setScreenId(savedShow.getScreen().getId());
            savedShowDTO.setMovieId(savedShow.getMovie().getMovieId());

            return savedShowDTO;
        } else {
            // Handle the case where Theatre, Screen, or Movie entities are not found
            return null;
        }
    }@Override
    public List<ShowDTO> getAllShows() {
        // Implement your logic to get all shows here
        // This can include querying the repository, mapping entities to DTOs, etc.

        List<Show> allShows = showRepository.findAll();

        List<ShowDTO> allShowsDTO = new ArrayList<>();
        for (Show show : allShows) {
            ShowDTO showDTO = new ShowDTO();
            showDTO.setShowId(show.getShowId());
            showDTO.setShowName(show.getShowName());


            showDTO.setShowTime(show.getShowTime());
            showDTO.setMovieId(show.getMovie().getMovieId());
            showDTO.setTheatreId(show.getTheatre().getId());
            showDTO.setScreenId(show.getScreen().getId());
            allShowsDTO.add(showDTO);
        }

        return allShowsDTO;
    }


    private Theatre getTheatreById(int theatreId) {
        return theatreRepository.findById(theatreId).orElse(null);
    }

    private Screen getScreenById(int screenId) {
        return screenRepository.findById(screenId).orElse(null);
    }

    private Movie getMovieById(int movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }
}