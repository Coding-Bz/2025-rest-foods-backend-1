package ch.noseryoung.REST_Foods.domain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drink")
public class Drink {

    @Id
    @GeneratedValue
    @Column(name = "drink_id", nullable = false)
    private UUID id;

    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @NotNull(message = "Price can't be null.")
    private Integer price;

    private String description;

    private String pictureLink;

    @NotNull(message = "Alcoholic must be specified.")
    private Boolean alcoholic;

    @NotNull(message = "Volume can't be null.")
    @DecimalMin(value = "0.01", message = "Volume must be greater than 0.")
    private Double volume;
}

