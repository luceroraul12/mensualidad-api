package Models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "subscripcion")
public class Subscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id-subscripcion", nullable = false)
    private UUID id;

    @Column(name = "nombre-subscripcion", nullable = false)
    private String nombre;

    public Subscripcion(UUID id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}