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

   /* @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private Ticket fromTickets;
    @ManyToOne
    @JoinColumn(name = "name",nullable = false)
    private Ticket toTickets; */

}

/*
 @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fromPlanet" )
    private Ticket fromTickets;
    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "toPlanet" )
    private Ticket toTickets;
 */
