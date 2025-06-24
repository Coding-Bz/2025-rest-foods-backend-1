package ch.noseryoung.REST_Foods.domain.Controller.Admin;

import ch.noseryoung.REST_Foods.domain.Model.Drink;
import ch.noseryoung.REST_Foods.domain.Service.Admin.AdminDrinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/admin/drink")
@CrossOrigin("http://localhost:5173/")

@CrossOrigin(origins = "http://localhost:5173")

public class AdminDrinkController {

    @Autowired
    AdminDrinkService adminDrinkService;

    @PostMapping("/")
    public ResponseEntity<Drink> createDrink(@Valid @RequestBody Drink drink) {
        if (drink.getPrice() < 1) {
            throw new IllegalArgumentException("Price of the drink can't be under 1!");
        }
        return ResponseEntity.ok(adminDrinkService.createDrink(drink));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable UUID id, @Valid @RequestBody Drink drink) {
        return ResponseEntity.ok(adminDrinkService.updateDrink(id, drink));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable UUID id) {
        adminDrinkService.deleteDrink(id);
        return ResponseEntity.noContent().build();
    }


}
