package ch.noseryoung.REST_Foods.domain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservation")

public class Reservation {

        @Id
        @GeneratedValue
        @Column(name = "reservation_id",  nullable = false)
        private UUID id;

        @NotEmpty
        private LocalTime time;

        @NotEmpty
        private Date dateTime;

        @NotEmpty
        private Integer partySize;

        @NotEmpty
        private String name;
        
    }

