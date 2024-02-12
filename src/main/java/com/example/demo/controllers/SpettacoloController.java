package com.example.demo.controllers;

import com.example.demo.ResponseMessage;
import com.example.demo.entities.Evento;
import com.example.demo.exceptions.DateWrongRangeException;
import com.example.demo.entities.Spettacolo;
import com.example.demo.repositories.SpettacoloRepository;
import com.example.demo.services.SpettacoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/spettacolo")
public class SpettacoloController {

    @Autowired
    private SpettacoloService spettacoloService;

    @Autowired
    private SpettacoloRepository spettacoloRepository;


    @GetMapping("/all")
    public ResponseEntity getAll() {

        List<Spettacolo> result =  spettacoloService.showAllShows();
        if ( result.size() <= 0 ) {
            return new ResponseEntity<>(new ResponseMessage("No results!"), HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{startDate}")
    public List<Spettacolo> getSpectaclesAfterDate(@Valid @PathVariable ("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start){
        return spettacoloRepository.findByFirstDayAfter(start);
    }

}
