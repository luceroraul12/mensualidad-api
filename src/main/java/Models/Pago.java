package Models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "subscripcion_id", referencedColumnName = "id-subscripcion" )
    private Subscripcion subscripcion;

}