package ar.my.mensualidades.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pagos_usuarios")
public class PagosUsuarios extends ModeloMensualidad{

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pago_id")
    Pago pago;

    @Column(name = "pago_fraccionado")
    Float pagoFraccionado;
}
