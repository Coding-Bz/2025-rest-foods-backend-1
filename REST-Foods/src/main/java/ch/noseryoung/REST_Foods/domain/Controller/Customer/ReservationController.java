package ch.noseryoung.REST_Foods.domain.Controller.Customer;

import ch.noseryoung.REST_Foods.domain.MailAdmin.JavaMailUtil;
import ch.noseryoung.REST_Foods.domain.Model.Drink;
import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import ch.noseryoung.REST_Foods.domain.Model.Seats;
import ch.noseryoung.REST_Foods.domain.Service.Customer.ReservationService;
import ch.noseryoung.REST_Foods.domain.Service.Customer.TableService;
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
@CrossOrigin(origins = "http://localhost:5173")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    TableService tableService;

    @GetMapping("/")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable UUID id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) throws Exception {
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

        if(reservation.getPartySize()>9){
            throw new IllegalArgumentException("For bigger sized reservations please call us!");
        }

        List<Seats> available = tableService.getAvailableTables(reservation.getDate(), reservation.getTime(), reservation.getPartySize());

        if (available.isEmpty()) {
            throw new IllegalArgumentException("No tables available at the selected time. Please select another time");
        }



        JavaMailUtil.sendMail(reservation.getEmail(),reservation.getName(),reservation.getDate(), reservation.getPartySize(),reservation.getTime());
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable UUID id, @Valid @RequestBody Reservation reservation) {
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
        return ResponseEntity.ok(reservationService.updateReservation(id, reservation));
    }


}
