package ch.noseryoung.REST_Foods.domain.Repository;

import ch.noseryoung.REST_Foods.domain.Model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, UUID> {


    long countByAlcoholic(boolean alcoholic);

    long countByCategory(String category);

    long countByPriceIsLessThan(double price);

    long countByPriceIsGreaterThan(double price);

    long countByPriceIsBetween(double low, double high);


    List<Drink> findByAlcoholic(boolean alcoholic);

    List<Drink> findByCategory(String category);

    List<Drink> findByPriceIsLessThan(double price);

    List<Drink> findByPriceIsGreaterThan(double price);

    List<Drink> findByPriceIsBetween(double low, double high);


}
