package ar.my.mensualidades.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagos")
public class Pago extends ModeloMensualidad{

    @Column
    private Double pago;

    @Column
    private LocalDate fechaDePago;

    @Column
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "factura_id",nullable = false)
    private Factura factura;

}