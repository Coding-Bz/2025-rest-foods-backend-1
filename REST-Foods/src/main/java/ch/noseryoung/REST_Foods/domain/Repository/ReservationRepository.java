package ch.noseryoung.REST_Foods.domain.Repository;

import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    long countByDate(LocalDate date);

    long countBytime(LocalTime time);

    long countBydateAndTime(LocalDate date, LocalTime time);

    long countByPartySize(int size);

    long countByName(String name);


    List<Reservation> findByDate(LocalDate date);

    List<Reservation> findByTime(LocalTime time);

    List<Reservation> findByName(String name);

    List<Reservation> findByPartySize(int size);

    List<Reservation> findByDateAndTime(LocalDate date, LocalTime time);

    List<Reservation> findByNameAndDate(String name, LocalDate date);


}
