package ar.my.mensualidades.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "porcentaje_usuarios_facturas")
public class PorcentajeUsuariosFacturas extends ModeloMensualidad{

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "porcentaje")
    private Float porcentaje;
}
