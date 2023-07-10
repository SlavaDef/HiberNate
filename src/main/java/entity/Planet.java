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
    @Column(name = "name",length = 500, nullable = false)
    private String name;
    @OneToMany(mappedBy = "fromPlanet",cascade = CascadeType.REMOVE)
    private List<Ticket> fromTickets;
    @OneToMany(mappedBy = "toPlanet",cascade = CascadeType.REMOVE)
    private List<Ticket> toTickets;
}
