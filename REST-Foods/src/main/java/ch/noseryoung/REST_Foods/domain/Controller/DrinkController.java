package ch.noseryoung.REST_Foods.domain.Controller;

import ch.noseryoung.REST_Foods.domain.Model.Drink;
import ch.noseryoung.REST_Foods.domain.Service.DrinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/drink")
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @GetMapping("/")
    public ResponseEntity<List<Drink>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrink(@PathVariable UUID id) {
        return ResponseEntity.ok(drinkService.getDrink(id));
    }

    @PostMapping("/")
    public ResponseEntity<Drink> createDrink(@Valid @RequestBody Drink drink) {
        return ResponseEntity.ok(drinkService.createDrink(drink));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@PathVariable UUID id, @Valid @RequestBody Drink drink) {
        return ResponseEntity.ok(drinkService.updateDrink(id, drink));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable UUID id) {
        drinkService.deleteDrink(id);
        return ResponseEntity.noContent().build();
    }
}
