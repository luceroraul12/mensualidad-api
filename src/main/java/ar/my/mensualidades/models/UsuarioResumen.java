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
public class UsuarioResumen extends ModeloMensualidad {
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @Column
    private Double costoDistribuido;
}
