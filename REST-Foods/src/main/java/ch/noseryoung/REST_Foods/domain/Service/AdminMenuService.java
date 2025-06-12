package ch.noseryoung.REST_Foods.domain.Service;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


    public long getCountDieteryRequirements(String dieteryRequirement) {
        return menuRepository.countByDietaryRequirements(dieteryRequirement);
    }


    public long getCountCategory(String category) {
        return menuRepository.countByCategory(category);
    }

    public long getCountAllergy(String allergy) {
        return menuRepository.countByAllergies(allergy);
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



    public List<Menu> getListByCategories(String category) {
        return menuRepository.findByCategory(category);
    }

    public List<Menu> getListByAllergy(String allergy) {
        return menuRepository.findByAllergies(allergy);
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


}





