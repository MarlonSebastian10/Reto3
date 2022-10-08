package com.usa.reto3.reto3.controllers;

import com.usa.reto3.reto3.model.Reservation;
import com.usa.reto3.reto3.service.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/api/Reservation")

public class ReservationController {
    @Autowired
    private ReservationServices reservationServices;

    @GetMapping("/all")
    public List<Reservation> getAll(){

        return reservationServices.getAll();
    }

    @GetMapping("/{id}") // localhost:8080/api/Category/21
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationServices.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return reservationServices.save(reservation);
    }
}
