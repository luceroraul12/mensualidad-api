package ar.my.mensualidades.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Double pago;

    @Column
    private LocalDate fechaDePago;

    @ManyToOne
    @JoinColumn(name = "factura_id", referencedColumnName = "id")
    private Factura factura;

    public Pago(Double pago, LocalDate fechaDePago, Factura factura) {
        this.pago = pago;
        this.fechaDePago = fechaDePago;
        this.factura = factura;
    }
}