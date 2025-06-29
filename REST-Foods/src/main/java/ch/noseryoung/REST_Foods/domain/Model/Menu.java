package ch.noseryoung.REST_Foods.domain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue
    @Column(name = "menu_id", nullable = false)
    private UUID id;

    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @NotNull(message = "Price can't be null.")
    private Integer price;

    @NotEmpty(message = "Category can't be empty.")
    private String category;

    @NotEmpty(message = "Dietary requirements can't be empty.")
    @Column(name = "dietary_requirements")
    private String dietaryRequirements;

    private String allergies;

    private String description;

    @NotNull(message = "Chef's choice can't be null.")
    @Column(name = "chefs_choice")
    private Boolean chefsChoice;

    private String pictureLink;
}
