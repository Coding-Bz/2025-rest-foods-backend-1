package ch.noseryoung.REST_Foods.domain.Repository;

import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import ch.noseryoung.REST_Foods.domain.Model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TableRepository extends JpaRepository<Seats, UUID>  {

  List<Seats> findByPartySizeGreaterThanEqual(int partySize);






}
