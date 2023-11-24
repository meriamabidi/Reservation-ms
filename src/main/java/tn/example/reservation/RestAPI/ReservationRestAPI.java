package tn.example.reservation.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.example.reservation.entities.Reservation;
import tn.example.reservation.services.ReservationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/reservations")
//kif nzyd il path hedhe ywali ignore il path par default mt3 il restController il rstcontroller ya3tik par default path /reservations ...
//KIF BCH naaml haja personaliser w nzyd ena il method lkol nwali lezem nzyd @requestMapping
public class ReservationRestAPI {

    private String title = "Hello, i'm the reservatione Micro Service";

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @Autowired
    private ReservationServiceImpl reservationService;

    @RequestMapping
    public List<Reservation> getListCandid() {
        return reservationService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
    }


    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateReservation(@PathVariable(value = "id") int id,
                                                      @RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReservation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }
}
