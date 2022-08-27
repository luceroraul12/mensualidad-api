package ar.my.mensualidades.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nombre;

}