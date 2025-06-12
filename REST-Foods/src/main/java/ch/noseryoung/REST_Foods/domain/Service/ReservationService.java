package ch.noseryoung.REST_Foods.domain.Service;

import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import ch.noseryoung.REST_Foods.domain.Repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservation(UUID id) {
        return reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No reservation found with this id!"));
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(UUID id, Reservation reservation) {
        reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This reservation doesn't exists"));
        reservation.setId(id);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(UUID id) {
        reservationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("This reservation doesn't exists"));
        reservationRepository.deleteById(id);
    }
}
