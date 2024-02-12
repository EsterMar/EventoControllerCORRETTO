package com.example.demo.controllers;

import com.example.demo.entities.Sala;
import com.example.demo.repositories.PostoRepository;
import com.example.demo.services.PostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posto")
public class PostoController {
    @Autowired
    private PostoService postoService;


    @GetMapping("/free")
    public boolean isThereFreeSeats(@RequestParam Integer sala){
        return postoService.FreeSeats(sala)>0;
    }

 /*   @GetMapping("/free2")
    public boolean isThereFreeSeats2(){
        Sala x = new Sala();
        x.setRoom_number(0);
        return postoService.FreeSeats(x)>0;
    }
*/
    @GetMapping("/occupied")
    public int getOccupiedSeats(@RequestParam Integer sala){
        return postoService.OccupiedSeats(sala);
    }
}
