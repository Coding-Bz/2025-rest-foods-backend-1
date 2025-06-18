package ch.noseryoung.REST_Foods.domain.Controller.Customer;

import ch.noseryoung.REST_Foods.domain.Model.Drink;
import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Service.Customer.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/drink")
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @GetMapping("/")
    public ResponseEntity<List<Drink>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }


    @GetMapping("/count")
    public long getDrinkCount() {
        return drinkService.countDrinks();
    }

    @GetMapping("/category")
    public ResponseEntity<List<Object>> getByCategory(@RequestParam String category) {
        long CountCategory = drinkService.countByCategory(category);
        if (CountCategory == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Drink> categoryList = drinkService.findByCategory(category);

        List<Object> response = new ArrayList<>();

        response.add(categoryList);
        response.add(CountCategory);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/price/less")
    public ResponseEntity<?> getByLessPrice(@RequestParam double price) {
        long countLess = drinkService.countByPriceLessThan(price);
        List<Drink> lessList = drinkService.findByPriceLessThan(price);

        if (countLess <= 0) {
            return new ResponseEntity<>("No drinks in that price range", HttpStatus.NOT_FOUND);
        }

        List<Object> response = new ArrayList<>();
        response.add(countLess);
        response.add(lessList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/price/greater")
    public ResponseEntity<?> getByGreaterPrice(@RequestParam double price) {
        long countGreater = drinkService.countByPriceGreaterThan(price);
        List<Drink> greaterList = drinkService.findByPriceGreaterThan(price);
        if (countGreater <= 0) {
            return new ResponseEntity<>("No drinks in that price range", HttpStatus.NOT_FOUND);
        }
        List<Object> response = new ArrayList<>();
        response.add(countGreater);
        response.add(greaterList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/price/between")
    public ResponseEntity<?> getByBetweenPrice(@RequestParam double start, @RequestParam double end) {
        long countBetween = drinkService.countByPriceBetween(start, end);
        List<Drink> betweenList = drinkService.findByPriceBetween(start, end);
        if (countBetween <= 0) {
            return new ResponseEntity<>("No drinks in that price range", HttpStatus.NOT_FOUND);
        }
        List<Object> response = new ArrayList<>();
        response.add(countBetween);
        response.add(betweenList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/alcoholic")
    public ResponseEntity<?> getByAlcoholic(@RequestParam boolean alcoholic) {
        List<Object> response = new ArrayList<>();
        long countBoolAlcoholic;
        List<Drink> alcoholicBoolDrinks;
        if (alcoholic) {
            countBoolAlcoholic = drinkService.countAlcoholicDrinks();
            alcoholicBoolDrinks = drinkService.AlcoholicDrinks();
        } else {
            countBoolAlcoholic = drinkService.countNonAlcoholicDrinks();
            alcoholicBoolDrinks = drinkService.NonAlcoholicDrinks();
        }

        response.add(countBoolAlcoholic);
        response.add(alcoholicBoolDrinks);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    @GetMapping("/filter")
    public ResponseEntity<Object> getFilter(@RequestParam(required = false) String category, @RequestParam(required = false) Integer lowPrice, @RequestParam(required = false) Integer highPrice,@RequestParam (required = false)Boolean alcoholic) {
        return null;
    }


}
