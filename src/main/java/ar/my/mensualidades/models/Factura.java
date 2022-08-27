package ar.my.mensualidades.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "factura")
@NoArgsConstructor
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nombre;

    public Factura(String nombre) {
        this.nombre = nombre;
    }
}