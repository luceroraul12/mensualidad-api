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
    private Double porcentaje;

    public PorcentajeUsuariosFacturas() {
    }

    public PorcentajeUsuariosFacturas(Long idFactura, Long idUsuario, Double porcentaje) {
        Factura factura = new Factura();
        factura.setId(idFactura);
        Usuario usuario = new Usuario();
        usuario.setId(idUsuario);
        this.factura = factura;
        this.usuario = usuario;
        this.porcentaje = porcentaje;
    }
}
