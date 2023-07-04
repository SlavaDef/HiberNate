package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "planet")
@Entity
@Data
public class Planet {
    @Id
    @Column(name = "id",length = 50, nullable = false)
    private String id;
    @Column(name = "name", length = 500, nullable = false)
    private String name;
}
