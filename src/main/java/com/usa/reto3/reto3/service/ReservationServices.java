package com.usa.reto3.reto3.service;

import com.usa.reto3.reto3.model.Reservation;
import com.usa.reto3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReservationServices {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){

        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){

        return reservationRepository.getReservation(id);
    }

    public Reservation save (Reservation reservation){
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationEncontrada = getReservation(reservation.getIdReservation());
            if(reservationEncontrada.isEmpty()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!= null) {
            Optional<Reservation> reservationEncontrada = getReservation(reservation.getIdReservation());
            if (!reservationEncontrada.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    reservationEncontrada.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationEncontrada.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationEncontrada.get().setStatus(reservation.getStatus());
                }
            }
            return reservationRepository.save(reservationEncontrada.get());
        }
        return reservation;
    }
    public boolean delete(int id){
        Boolean respuesta = getReservation(id).map(elemento ->{
            reservationRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
