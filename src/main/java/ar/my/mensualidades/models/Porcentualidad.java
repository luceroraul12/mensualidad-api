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
public class Porcentualidad extends ModeloMensualidad{

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column
    private Double porcentaje;

    @Column
    private Factura factura;
}
