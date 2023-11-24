package tn.example.reservation.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 795450928237931201L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    private Date anneeUniv;
    private boolean estValide;

    public Reservation(Date anneeUniv, boolean estValide) {
        super();
        this.anneeUniv = anneeUniv;
        this.estValide = estValide;

    }
}
