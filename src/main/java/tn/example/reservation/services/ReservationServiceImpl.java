package tn.example.reservation.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.example.reservation.entities.Reservation;
import tn.example.reservation.repositories.ReservationRepository;


import java.util.List;

@AllArgsConstructor
@Service
public class ReservationServiceImpl implements IReservationService {

    private ReservationRepository reservationeRepository;

    @Override
    public List<Reservation> getAll() {
        return reservationeRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservatione) {
        return reservationeRepository.save(reservatione);
    }

    @Override
    public Reservation updateReservation(int id, Reservation newReservation) {
        if (reservationeRepository.findById(id).isPresent()) {
            Reservation existingReservation = reservationeRepository.findById(id).get();
            existingReservation.setAnneeUniv(newReservation.getAnneeUniv());
           // existingReservation.setEstValide(newReservation.getEstValide());


            return reservationeRepository.save(existingReservation);
        } else
            return null;
    }

    @Override
    public String deleteReservation(int id) {
        if (reservationeRepository.findById(id).isPresent()) {
            reservationeRepository.deleteById(id);
            return "reservation supprimé";
        } else
            return "reservation non supprimé";
    }
}