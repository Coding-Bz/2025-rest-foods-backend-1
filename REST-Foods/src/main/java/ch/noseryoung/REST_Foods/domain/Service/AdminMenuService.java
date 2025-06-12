package ch.noseryoung.REST_Foods.domain.Service;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class AdminMenuService {
    private final MenuRepository menuRepository;


    @Autowired
    public AdminMenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;

    }

    public long getAllMenusCount() {
        return menuRepository.count();
    }


    public Menu createMenu(Menu menu) {
        Menu savedCustomer = menuRepository.save(menu);
        return savedCustomer;
    }


    public Menu updateMenu(UUID menuID, Menu menuDetails) {
        Menu menu = menuRepository.findById(menuID)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found"));

        menu.setName(menuDetails.getName());
        menu.setDescription(menuDetails.getDescription());
        menu.setAllergies(menuDetails.getAllergies());
        menu.setCategory(menuDetails.getCategory());
        menu.setChefsChoice(menuDetails.getChefsChoice());
        menu.setPrice(menuDetails.getPrice());
        menu.setDietaryRequirements(menuDetails.getDietaryRequirements());
        menu.setPictureLink(menuDetails.getPictureLink());

        return menuRepository.save(menu);
    }


    public void deleteMenu(UUID menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found"));
        menuRepository.delete(menu);
    }

}





