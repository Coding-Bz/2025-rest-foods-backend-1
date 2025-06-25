package ch.noseryoung.REST_Foods.domain.Model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seats")
public class Seats {

    @Id
    @GeneratedValue
    @Column(name = "table_id", nullable = false)
    private UUID id;

    @Column(name = "table_capacity")
    @NotNull(message = "Party size can't be null.")
    private Integer tableCapacity;

    private String location;

}