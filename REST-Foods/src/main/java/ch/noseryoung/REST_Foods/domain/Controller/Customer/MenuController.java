package ch.noseryoung.REST_Foods.domain.Controller.Customer;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Service.Customer.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService customerService) {
        this.menuService = customerService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Menu>> getAllMenus() {
        return new ResponseEntity<>(menuService.getAllMenus(), HttpStatus.OK);
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<Menu> getMenuById(@Valid @PathVariable UUID menuId) {
        return new ResponseEntity<>(menuService.getMenuByID(menuId), HttpStatus.OK);
    }


    @GetMapping("/category")
    public ResponseEntity<List<Object>> getCategoryMenus(@RequestParam String category) {
        long count = menuService.getCountCategory(category);
        List<Menu> list = menuService.getListByCategories(category);

        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/dieteryRequirements")
    public ResponseEntity<List<Object>> getDieteryRequirements(@RequestParam String requirement) {
        long count = menuService.getCountDieteryRequirements(requirement);
        List<Menu> list = menuService.getListByDieteryRequirement(requirement);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);


    }

    @GetMapping("/allergies")
    public ResponseEntity<List<Object>> getAllergies(@RequestParam String allergy) {
        long count = menuService.getCountAllergy(allergy);
        List<Menu> list = menuService.getListByAllergy(allergy);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/chefsChoice")
    public ResponseEntity<List<Object>> getChefsChoice(@RequestParam boolean choice) {
        long count = menuService.getCountChefsChoice(choice);
        if (count <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Menu> list = menuService.getListByChefsChoice(choice);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/price/low")
    public ResponseEntity<Object> getPrice(@RequestParam int price) {
        long count = menuService.getCountPricelessThan(price);
        if (count <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Menu> list = menuService.getListByPricelessThan(price);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/price/high")

    public ResponseEntity<Object> getPriceHigh(@RequestParam int price) {
        long count = menuService.getCountPriceGreaterThan(price);
        if (count <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Menu> list = menuService.getListByPriceGreaterThan(price);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/price/between")
    public ResponseEntity<Object> getPriceBetween(@RequestParam int price1, @RequestParam int price2) {
        long count = menuService.getCountBetween(price1, price2);
        if (count <= 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Menu> list = menuService.getListBetween(price1, price2);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filter")
    public ResponseEntity<Object> getFilter(@RequestParam(required = false) Boolean choice, @RequestParam(required = false) String category, @RequestParam(required = false) String requirement, @RequestParam(required = false) int lowPrice, @RequestParam(required = false) int highPrice, @RequestParam(required = false) String allergy) {
        List<Menu> all = menuService.getAllMenus();
        List<Menu> filtered = all.stream()
                .filter(m -> choice == null || m.getChefsChoice() == choice)
                .filter(m -> category == null || m.getCategory().equalsIgnoreCase(category))
                .filter(m -> highPrice == 0 || m.getPrice() <= highPrice)
                .filter(m-> lowPrice ==0 || m.getPrice() >= lowPrice)
                .filter(m->requirement ==null || m.getDietaryRequirements().contains(requirement))
                .filter(m -> allergy == null || !m.getAllergies().contains(allergy))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(filtered);
    }


}
