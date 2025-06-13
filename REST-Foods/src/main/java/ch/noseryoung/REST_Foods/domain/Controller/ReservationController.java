package ch.noseryoung.REST_Foods.domain.Controller;

import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import ch.noseryoung.REST_Foods.domain.Service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable UUID id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        if (reservation.getDate().isBefore(today)) {
            throw new IllegalArgumentException("Reservation date must be today or in the future.");
        }

        if (reservation.getDate().isEqual(today) && reservation.getTime().isBefore(now)) {
            throw new IllegalArgumentException("Reservation time must be in the future.");
        }
        if (reservation.getPartySize() < 1) {
            throw new IllegalArgumentException("Party size must be at least 1!");
        }
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable UUID id, @Valid @RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservation));
    }


}
