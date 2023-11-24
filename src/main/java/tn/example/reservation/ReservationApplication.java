package tn.example.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.example.reservation.entities.Reservation;
import tn.example.reservation.repositories.ReservationRepository;

@SpringBootApplication
public class ReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }

    @Autowired
    private ReservationRepository repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
//            repository.save(new Reservation( 2023-12-30, true));
//            repository.save(new Reservation( 2023-12-30, false));
//            repository.save(new Reservation( 2023-12-30, true));
// fetch
            repository.findAll().forEach(System.out::println);
        };
    }
}

