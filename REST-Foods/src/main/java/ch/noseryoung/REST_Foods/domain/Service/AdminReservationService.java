package ch.noseryoung.REST_Foods.domain.Service;

import ch.noseryoung.REST_Foods.domain.Model.Menu;
import ch.noseryoung.REST_Foods.domain.Model.Reservation;
import ch.noseryoung.REST_Foods.domain.Repository.MenuRepository;
import ch.noseryoung.REST_Foods.domain.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class AdminReservationService {
    private final ReservationRepository reservationRepository;


    @Autowired
    public AdminReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;

    }

    public long getAllCount(){
        return reservationRepository.count();
    }

    public long getCountDate(LocalDate date) {
        return reservationRepository.countByDate(date);
    }

    public long getCountTime(LocalTime time) {
        return reservationRepository.countBytime(time);
    }

    public long getCountTimeAndDate(LocalTime time, LocalDate date) {
        return reservationRepository.countBydateAndTime(date, time);
    }

    public long getCountPartySize(int size) {
        return reservationRepository.countByPartySize(size);
    }

    public long getCountName(String name){
        return reservationRepository.countByName(name);
    }



    public List<Reservation> getListName(String name) {
        return reservationRepository.findByName(name);
    }

    public List<Reservation> getListNameAndDate(String name, LocalDate date) {
        return reservationRepository.findByNameAndDate(name, date);
    }


    public List<Reservation> getListDate(LocalDate date) {
        return reservationRepository.findByDate(date);
    }

    public List<Reservation> getListTime(LocalTime time) {
        return reservationRepository.findByTime(time);
    }


    public List<Reservation> getListDateAndTime(LocalTime time, LocalDate date) {
        return reservationRepository.findByDateAndTime(date,time);
    }



}





