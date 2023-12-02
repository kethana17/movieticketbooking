package com.hexaware.movieticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.movieticketbooking.dto.ScreenDTO;
import com.hexaware.movieticketbooking.service.IScreenService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/screens")
public class ScreenRestController {

    @Autowired
    private IScreenService screenService;

    @PostMapping("/add/{theatreId}")
    public ResponseEntity<ScreenDTO> addScreen(@RequestBody ScreenDTO screenDTO, @PathVariable int theatreId) {
        ScreenDTO addedScreen = screenService.addScreen(screenDTO, theatreId);
        if (addedScreen != null) {
            return new ResponseEntity<>(addedScreen, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{screenId}")
    public ResponseEntity<Void> removeScreen(@PathVariable int screenId) {
        screenService.removeScreen(screenId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScreenDTO>> getAllScreens() {
        List<ScreenDTO> screens = screenService.getAllScreens();
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

    @GetMapping("/theatre/{theatreId}")
    public ResponseEntity<List<ScreenDTO>> getScreensByTheatre(@PathVariable int theatreId) {
        List<ScreenDTO> screens = screenService.getScreensByTheatre(theatreId);
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }
}