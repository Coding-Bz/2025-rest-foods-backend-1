package ch.noseryoung.REST_Foods.domain.Service.Customer;

import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import ch.noseryoung.REST_Foods.domain.Model.Seats;
import ch.noseryoung.REST_Foods.domain.Repository.ReservationRepository;
import ch.noseryoung.REST_Foods.domain.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Seats> getAvailableTables(LocalDate date, LocalTime startTime, int partySize) {
        LocalTime endTime = startTime.plusHours(3);

        List<Seats> allSuitableTables = tableRepository.findByTableCapacityGreaterThanEqual(partySize);
        List<Seats> availableTables = new ArrayList<>();

        for (Seats table : allSuitableTables) {
            boolean isFree = true;

            List<Reservation> reservations = reservationRepository.findBySeatIDAndDate(table.getId(), date);

            for (Reservation r : reservations) {
                LocalTime existingStart = r.getTime();
                LocalTime existingEnd = existingStart.plusHours(3);

                if (startTime.isBefore(existingEnd) && existingStart.isBefore(endTime)) {
                    isFree = false;
                    break;
                }
            }

            if (isFree) {
                availableTables.add(table);
            }
        }

        return availableTables;
    }
}
