package ch.noseryoung.REST_Foods.domain.Controller;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Service.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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

    @PostMapping("/")
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.createMenu(menu), HttpStatus.CREATED);
    }

    @PutMapping("/{menuId}")
    public ResponseEntity<Menu> updateMenu(@Valid @PathVariable UUID menuId, @Valid @RequestBody Menu details) throws Exception {
        return new ResponseEntity<>(menuService.updateMenu(menuId, details), HttpStatus.OK);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@Valid @PathVariable("menuId") UUID menuId) {
        menuService.deleteMenu(menuId);
        return ResponseEntity.noContent().build();
    }


}
