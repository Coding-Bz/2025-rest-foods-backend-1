package ch.noseryoung.REST_Foods.domain.Service;

import ch.noseryoung.REST_Foods.domain.Model.Drink;
import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Repository.DrinkRepository;
import ch.noseryoung.REST_Foods.domain.Repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.UUID;

@Service
public class AdminDrinkService {

    private final DrinkRepository drinkRepository;


    @Autowired
    public AdminDrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;

    }

    public Drink getDrink(UUID id) {
        return drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no Drink with this id!"));
    }

    public Drink createDrink(Drink drink) {
        return drinkRepository.save(drink);
    }

    public Drink updateDrink(UUID id, Drink drink) {
        drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no Drink with this id!"));
        drink.setId(id);
        return drinkRepository.save(drink);
    }

    public void deleteDrink(UUID id) {
        drinkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no Drink with this id!"));
        drinkRepository.deleteById(id);
    }


}








