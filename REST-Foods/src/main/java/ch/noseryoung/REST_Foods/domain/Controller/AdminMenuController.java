package ch.noseryoung.REST_Foods.domain.Controller;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Service.AdminMenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/admin/menu")
public class AdminMenuController {
    private final AdminMenuService adminMenuService;

    @Autowired
    public AdminMenuController(AdminMenuService adminMenuService) {
        this.adminMenuService = adminMenuService;
    }


    @GetMapping("/count")
    public ResponseEntity<Long> getCountMenus() {
        return new ResponseEntity<>(adminMenuService.getAllMenusCount(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Object>> getCategoryMenus(@RequestParam String category) {
        long count = adminMenuService.getCountCategory(category);
        List<Menu> list = adminMenuService.getListByCategories(category);

        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/dieteryRequirements")
    public ResponseEntity<List<Object>> getDieteryRequirements(@RequestParam String requirement) {
        long count = adminMenuService.getCountDieteryRequirements(requirement);
        List<Menu> list = adminMenuService.getListByDieteryRequirement(requirement);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);


    }

    @GetMapping("/allergies")
    public ResponseEntity<List<Object>> getAllergies(@RequestParam String allergy) {
        long count = adminMenuService.getCountAllergy(allergy);
        List<Menu> list = adminMenuService.getListByAllergy(allergy);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/chefsChoice")
    public ResponseEntity<List<Object>> getChefsChoice(@RequestParam boolean choice) {
        long count = adminMenuService.getCountChefsChoice(choice);
        List<Menu> list = adminMenuService.getListByChefsChoice(choice);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/price/low")
    public ResponseEntity<Object> getPrice(@RequestParam int price) {
        long count = adminMenuService.getCountPricelessThan(price);
        List<Menu> list = adminMenuService.getListByPricelessThan(price);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/price/high")

    public ResponseEntity<Object> getPriceHigh(@RequestParam int price) {
        long count = adminMenuService.getCountPriceGreaterThan(price);
        List<Menu> list = adminMenuService.getListByPriceGreaterThan(price);
        List<Object> response = new ArrayList<>();
        response.add(count);
        response.add(list);
        return ResponseEntity.ok(response);

    }


}
