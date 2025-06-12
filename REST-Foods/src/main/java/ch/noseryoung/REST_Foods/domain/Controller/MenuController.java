package ch.noseryoung.REST_Foods.domain.Controller;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Services.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService customerService) {
        this.menuService = customerService;
    }

    @GetMapping("/menu")
    public ResponseEntity<List<Menu>> getAllMenus() {
        return new ResponseEntity<>(menuService.getAllMenus(), HttpStatus.OK);
    }

    @GetMapping("/menu/{menuId}")
    public ResponseEntity<Menu> getMenuById(@Valid @PathVariable UUID customerId) {
        return new ResponseEntity<>(menuService.getMenuByID(customerId), HttpStatus.OK);
    }

    @PostMapping("/menu")
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody Menu customer) {
        return new ResponseEntity<>(menuService.createMenu(customer), HttpStatus.CREATED);
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity<Menu> updateMenu(@Valid @PathVariable UUID id, @RequestBody Menu details) throws Exception {
        return new ResponseEntity<>(menuService.updateMenu(id, details), HttpStatus.OK);
    }

    @DeleteMapping("/menu/{menuId}")
    public ResponseEntity<Void> deleteMenu(@Valid @PathVariable("menuId") UUID customerId) {
        menuService.deleteMenu(customerId);
        return ResponseEntity.noContent().build();
    }


}
