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


    @PostMapping("/menu")
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody Menu menu) {
        return new ResponseEntity<>(adminMenuService.createMenu(menu), HttpStatus.CREATED);
    }

    @PutMapping("/{menuId}")
    public ResponseEntity<Menu> updateMenu(@Valid @PathVariable UUID menuId, @Valid @RequestBody Menu details) throws Exception {
        return new ResponseEntity<>(adminMenuService.updateMenu(menuId, details), HttpStatus.OK);
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@Valid @PathVariable("menuId") UUID menuId) {
        adminMenuService.deleteMenu(menuId);
        return ResponseEntity.noContent().build();
    }

}
