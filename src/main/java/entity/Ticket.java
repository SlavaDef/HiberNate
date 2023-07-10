package entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Table(name = "ticket")
@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", insertable = false, updatable = false)
    private Data createdAt;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


    @ToString.Exclude
    @ManyToOne
    @Column(name = "from_planet_id", nullable = false)
    private Planet fromPlanetId;


    @ToString.Exclude
    @ManyToOne
    @Column(name = "to_planet_id", nullable = false)
    private Planet toPlanetId;

}
