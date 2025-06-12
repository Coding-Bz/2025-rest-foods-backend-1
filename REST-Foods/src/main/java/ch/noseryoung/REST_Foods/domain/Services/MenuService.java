package ch.noseryoung.REST_Foods.domain.Services;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Menu createMenu(Menu menu) {
        Menu savedCustomer = menuRepository.save(menu);
        return savedCustomer;
    }

    public Menu updateMenu(UUID menuID, Menu menuDetails) {
        Menu menu = menuRepository.findById(menuID)
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        menu.setName(menuDetails.getName());
        menu.setDescription(menuDetails.getDescription());
        menu.setAllergies(menuDetails.getAllergies());
        menu.setCategory(menuDetails.getCategory());
        menu.setChefsChoice(menuDetails.getChefsChoice());
        menu.setPrice(menuDetails.getPrice());
        menu.setDietaryRequirements(menuDetails.getDietaryRequirements());

        return menuRepository.save(menu);
    }


    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuByID(UUID menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
    }


    public void deleteMenu(UUID menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
        menuRepository.delete(menu);
    }


}

