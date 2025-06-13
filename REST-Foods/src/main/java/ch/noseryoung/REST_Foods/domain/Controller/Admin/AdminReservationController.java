package ch.noseryoung.REST_Foods.domain.Controller.Admin;

import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import ch.noseryoung.REST_Foods.domain.Service.Admin.AdminReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin/reservation")
public class AdminReservationController {

    private final AdminReservationService adminReservationService;

    @Autowired
    public AdminReservationController(AdminReservationService adminReservationService) {
        this.adminReservationService = adminReservationService;
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountReservations() {
        return new ResponseEntity<>(adminReservationService.getAllCount(), HttpStatus.OK);
    }

    @GetMapping("/time")
    public ResponseEntity<List<Object>> getTimeReservations(@RequestParam LocalTime time) {
        long count = adminReservationService.getCountTime(time);
        List<Reservation> list = adminReservationService.getListTime(time);

        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);


    }

    @GetMapping("/date")
    public ResponseEntity<List<Object>> getDateReservations(@RequestParam LocalDate date) {
        List<Reservation> list = adminReservationService.getListDate(date);
        long count = adminReservationService.getCountDate(date);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/dateAndtime")
    public ResponseEntity<List<Object>> getDateAndTimeReservations(@RequestParam LocalDate date, @RequestParam LocalTime time) {
        long count = adminReservationService.getCountTimeAndDate(time, date);
        List<Reservation> list = adminReservationService.getListDateAndTime(time, date);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Object>> getCustomerReservations(@RequestParam String name, @RequestParam LocalDate date) {
        long count = adminReservationService.getCountName(name);
        List<Reservation> list = adminReservationService.getListName(name);
        Object side = adminReservationService.getListNameAndDate(name, date);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        response.add(side);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/partySize")
    public long getPartySize(@RequestParam int partySize) {
        long count = adminReservationService.getCountPartySize(partySize);
        return count;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable UUID id) {
        adminReservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable UUID id, @Valid @RequestBody Reservation reservation) {
        return ResponseEntity.ok(adminReservationService.updateReservation(id, reservation));
    }

}
