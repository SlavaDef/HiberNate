package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;

    @Column(name = "name", length = 500, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fromPlanet" )
    private List<Ticket> fromTickets;
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "toPlanet" )
    private List<Ticket> toTickets;

}
