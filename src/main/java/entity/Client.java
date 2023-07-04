package entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "client")
@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long  id;
    @Column(name = "name", length = 200, nullable = false)
   private String name;
}
