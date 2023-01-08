package ar.my.mensualidades.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class UsuarioCosto extends ModeloMensualidad {
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    @Column
    private Double costoDistribuido;
}