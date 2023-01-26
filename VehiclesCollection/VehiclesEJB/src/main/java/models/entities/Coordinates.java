package models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Coordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "x")
    private Float x;

    @Column(name = "y")
    private Long y;

    @OneToMany(mappedBy = "coordinates", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Set<Vehicle> vehicles;
}
