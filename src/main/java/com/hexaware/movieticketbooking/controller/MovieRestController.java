package com.hexaware.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.movieticketbooking.dto.MovieDTO;
import com.hexaware.movieticketbooking.service.IMovieService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    @Autowired
    private IMovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO addedMovie = movieService.addMovie(movieDTO);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int movieId) {
        movieService.removeMovie(movieId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/getMovieByName/{movieName}")
    public ResponseEntity<MovieDTO> getMovieByName(@PathVariable String movieName) {
        MovieDTO movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/updateMovie/{movieId}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable int movieId, @RequestBody MovieDTO movieDTO) {
        MovieDTO updatedMovie = movieService.updateMovie(movieId, movieDTO);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }
}