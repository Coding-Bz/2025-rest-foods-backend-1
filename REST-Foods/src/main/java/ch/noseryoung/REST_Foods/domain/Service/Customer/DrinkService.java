package ch.noseryoung.REST_Foods.domain.Service.Customer;

import ch.noseryoung.REST_Foods.domain.Model.Drink;
import ch.noseryoung.REST_Foods.domain.Repository.DrinkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DrinkService {
    @Autowired
    DrinkRepository drinkRepository;

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Drink getDrink(UUID id) {
        return drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no Drink with this id!"));
    }

    public long countDrinks() {
        return drinkRepository.count();

    }

    public long countAlcoholicDrinks() {
        return drinkRepository.countByAlcoholic(true);

    }

    public long countNonAlcoholicDrinks() {
        return drinkRepository.countByAlcoholic(false);

    }

    public long countByCategory(String category) {
        return drinkRepository.countByCategory(category);
    }

    public long countByPriceLessThan(double price) {
        return drinkRepository.countByPriceIsLessThan(price);
    }

    public long countByPriceGreaterThan(double price) {
        return drinkRepository.countByPriceIsGreaterThan(price);
    }


    public long countByPriceBetween(double start, double end) {
        return drinkRepository.countByPriceIsBetween(start, end);
    }


    public List<Drink> AlcoholicDrinks() {
        return drinkRepository.findByAlcoholic(true);
    }

    public List<Drink> NonAlcoholicDrinks() {
        return drinkRepository.findByAlcoholic(false);
    }


    public List<Drink> findByCategory(String category) {
        return drinkRepository.findByCategory(category);
    }

    public List<Drink> findByPriceLessThan(double price) {
        return drinkRepository.findByPriceIsLessThan(price);
    }

    public List<Drink> findByPriceGreaterThan(double price) {
        return drinkRepository.findByPriceIsGreaterThan(price);
    }

    public List<Drink> findByPriceBetween(double start, double end) {
        return drinkRepository.findByPriceIsBetween(start, end);
    }


}
