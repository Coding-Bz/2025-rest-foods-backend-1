package ch.noseryoung.REST_Foods.domain.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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

        @NotNull(message = "Time must not be null.")
        @JsonFormat(pattern = "HH:mm")
        private LocalTime time;

        @NotNull(message = "Date must not be null.")
        private LocalDate date;

        @NotNull(message = "Party size must not be null.")
        private Integer partySize;

        @NotEmpty(message = "Name must not be empty.")
        private String name;
}
