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
@RequiredArgsConstructor
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pago pago = (Pago) o;
        return id != null && Objects.equals(id, pago.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}