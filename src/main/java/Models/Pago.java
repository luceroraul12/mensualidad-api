package Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "costo-pago", nullable = false)
    private Double costo;

    @Column(name = "fecha-pago", nullable = false)
    private LocalDate fechaPago;

    @ManyToOne
    @JoinColumn(name = "subscripcion_id", referencedColumnName = "id-subscripcion" )
    private Subscripcion subscripcion;


    public Pago(UUID id, Double costo, LocalDate fechaPago, Subscripcion subscripcion) {
        this.id = id;
        this.costo = costo;
        this.fechaPago = fechaPago;
        this.subscripcion = subscripcion;
    }

    public Pago(Double costo, LocalDate fechaPago, Subscripcion subscripcion) {
        this.costo = costo;
        this.fechaPago = fechaPago;
        this.subscripcion = subscripcion;
    }
}