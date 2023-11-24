package tn.example.reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.example.reservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
 /*   @Query("select c from Reservation c where c.nom like :name")
    public Page<Reservation> candidatByNom(@Param("name") String n, Pageable pageable);
*/
}
