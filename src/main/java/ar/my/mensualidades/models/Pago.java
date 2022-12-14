package ar.my.mensualidades.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pago")
public class Pago extends ModeloMensualidad{

    @Column
    private Double pago;

    @Column
    private LocalDate fechaDePago;

    @Column
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "factura_ID",nullable = false)
    private Factura factura;

}