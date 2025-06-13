package ch.noseryoung.REST_Foods.domain.Service.Customer;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
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


    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuByID(UUID menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found"));
    }

    public List<Menu> getListByCategories(String category) {
        return menuRepository.findByCategory(category);
    }

    public List<Menu> getListByAllergy(String allergy) {
        //return menuRepository.findByAllergies(allergy);
        return menuRepository.findByAllergyContains(allergy);
    }

    public List<Menu> getListByDieteryRequirement(String dieteryRequirement) {
        return menuRepository.findByDietaryRequirements(dieteryRequirement);
    }

    public List<Menu> getListByChefsChoice(boolean chefChoice) {
        return menuRepository.findByChefsChoice(chefChoice);
    }

    public List<Menu> getListByPricelessThan(double price) {
        return menuRepository.findByPriceIsLessThan(price);
    }

    public List<Menu> getListByPriceGreaterThan(double price) {
        return menuRepository.findByPriceIsGreaterThan(price);
    }


    public long getCountDieteryRequirements(String dieteryRequirement) {
        return menuRepository.countByDietaryRequirements(dieteryRequirement);
    }


    public long getCountCategory(String category) {
        return menuRepository.countByCategory(category);
    }

    public long getCountAllergy(String allergy) {
        //return menuRepository.countByAllergies(allergy);
        return menuRepository.countByAllergyContains(allergy);
    }

    public long getCountChefsChoice(boolean chefChoice) {
        return menuRepository.countByChefsChoice(chefChoice);

    }

    public long getCountPricelessThan(double price) {
        return menuRepository.countByPriceIsLessThan(price);
    }

    public long getCountPriceGreaterThan(double price) {
        return menuRepository.countByPriceIsGreaterThan(price);
    }

    public long getCountBetween(double min, double max) {
        return menuRepository.countByPriceIsBetween(min, max);
    }

    public List<Menu> getListBetween(double min, double max) {
        return menuRepository.findByPriceIsBetween(min, max);
    }

}

