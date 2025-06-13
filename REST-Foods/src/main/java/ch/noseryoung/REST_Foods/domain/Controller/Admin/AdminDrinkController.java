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

public class AdminDrinkController {

    @Autowired
    AdminDrinkService adminDrinkService;


    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrink(@PathVariable UUID id) {
        return ResponseEntity.ok(adminDrinkService.getDrink(id));
    }

    @PostMapping("/")
    public ResponseEntity<Drink> createDrink(@Valid @RequestBody Drink drink) {
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
