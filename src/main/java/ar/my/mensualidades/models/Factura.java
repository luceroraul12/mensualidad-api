package ar.my.mensualidades.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "factura")
public class Factura extends ModeloMensualidad{

    @Column
    private String nombre;

    @Column
    private String url;

}