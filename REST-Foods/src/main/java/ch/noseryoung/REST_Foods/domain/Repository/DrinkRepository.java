package ch.noseryoung.REST_Foods.domain.Repository;

import ch.noseryoung.REST_Foods.domain.Model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, UUID> {
}
