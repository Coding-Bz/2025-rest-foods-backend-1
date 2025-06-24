package ch.noseryoung.REST_Foods.domain.Controller.Customer;

import ch.noseryoung.REST_Foods.domain.Model.Seats;
import ch.noseryoung.REST_Foods.domain.Service.Customer.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tables")
@CrossOrigin(origins = "http://localhost:5173")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping("/available")
    public ResponseEntity<List<Seats>> getAvailable(
            @RequestParam LocalDate date,
            @RequestParam LocalTime time,
            @RequestParam int partySize
    ) {
        return ResponseEntity.ok(tableService.getAvailableTables(date, time, partySize));
    }
}
