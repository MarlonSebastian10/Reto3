package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.model.Admin;
import com.usa.reto3.reto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    public List<Reservation> getAll(){

        return (List<Reservation>) reservationCRUDRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){

        return reservationCRUDRepository.findById(id);
    }

    public Reservation save(Reservation reservation){

        return reservationCRUDRepository.save(reservation);
    }

    public void delete(Reservation reservation){

        reservationCRUDRepository.delete(reservation);
    }
}
