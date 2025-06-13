package ch.noseryoung.REST_Foods.domain.Repository;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {
    long countByDietaryRequirements(String dietaryRequirements);

    long countByCategory(String category);

    long countByAllergies(String allergies);

    long countByChefsChoice(boolean chefsChoice);

    long countByPriceIsLessThan(double price);

    long countByPriceIsGreaterThan(double price);

    long countByPriceIsBetween(double start, double end);


    List<Menu> findByCategory(String category);

    List<Menu> findByAllergies(String allergies);

    List<Menu> findByDietaryRequirements(String dietaryRequirements);

    List<Menu> findByChefsChoice(boolean chefsChoice);

    List<Menu> findByPriceIsLessThan(double price);

    List<Menu> findByPriceIsGreaterThan(double price);

    List<Menu> findByPriceIsBetween(double start, double end);


}
