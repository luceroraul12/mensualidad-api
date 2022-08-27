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

    @Column(name = "fecha-pago")
    private LocalDate fechaPago;

    @ManyToOne
    @JoinColumn(name = "subscripcion_id", referencedColumnName = "id-subscripcion" )
    private Subscripcion subscripcion;

}