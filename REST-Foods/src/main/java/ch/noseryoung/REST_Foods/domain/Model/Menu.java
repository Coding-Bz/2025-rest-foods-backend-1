package ch.noseryoung.REST_Foods.domain.Model;

import jakarta.persistence.*;
        import jakarta.validation.constraints.NotEmpty;
import lombok.*;
        import java.util.UUID;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "menu_id",  nullable = false)
    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private Integer price;
    @NotEmpty
    private String category;
    @NotEmpty
    @Column(name = "dietary_requirements")
    private String dietaryReq;
    private String allergies;
    private String description;
    @NotEmpty
    @Column(name = "chefs_Choice")
    private Boolean chefsChoice;
}