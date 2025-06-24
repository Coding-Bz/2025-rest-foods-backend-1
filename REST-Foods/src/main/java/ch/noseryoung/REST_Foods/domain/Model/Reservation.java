package ch.noseryoung.REST_Foods.domain.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "reservation_id", nullable = false)
    private UUID id;

    @NotNull(message = "Time can't be null.")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    @NotNull(message = "Date can't be null.")
    private LocalDate date;

    @NotNull(message = "Party size can't be null.")
    private Integer partySize;

    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @NotEmpty
    @Email
    @NotEmpty(message = "Email can't be empty")
    private String email;

   //@NotEmpty(message = "Please chosse a avaliable seat")
    private UUID seatID;

   // @NotEmpty
    private String telephoneNumber;

}
