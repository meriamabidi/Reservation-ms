package tn.example.reservation.services;

import tn.example.reservation.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> getAll();

    Reservation addReservation(Reservation candidate);

    Reservation updateReservation(int id, Reservation newReservation);

    String deleteReservation(int id);

}
