package ar.my.mensualidades.models.converters;

import ar.my.mensualidades.dto.PorcentajeUsuariosFacturasDto;
import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.PorcentajeUsuariosFacturas;
import ar.my.mensualidades.models.Usuario;

public class PorcentajeUsuariosFacturasConverter extends Converter<PorcentajeUsuariosFacturas, PorcentajeUsuariosFacturasDto>{
    @Override
    PorcentajeUsuariosFacturasDto toDto(PorcentajeUsuariosFacturas porcentajeUsuariosFacturas) {
        return new PorcentajeUsuariosFacturasDto(
                porcentajeUsuariosFacturas.getId(),
                porcentajeUsuariosFacturas.getFactura().getId(),
                porcentajeUsuariosFacturas.getUsuario().getId(),
                porcentajeUsuariosFacturas.getPorcentaje()
        );
    }

    @Override
    PorcentajeUsuariosFacturas toEntidad(PorcentajeUsuariosFacturasDto porcentajeUsuariosFacturasDto) {
        PorcentajeUsuariosFacturas entidad = new PorcentajeUsuariosFacturas();
        Usuario usuario = new Usuario();
        Factura factura = new Factura();
        usuario.setId(porcentajeUsuariosFacturasDto.getIdUsuario());
        factura.setId(porcentajeUsuariosFacturasDto.getIdFactura());

        entidad.setId(porcentajeUsuariosFacturasDto.getId());
        entidad.setUsuario(usuario);
        entidad.setFactura(factura);
        entidad.setPorcentaje(porcentajeUsuariosFacturasDto.getPorcentaje());
        return entidad;
    }
}
