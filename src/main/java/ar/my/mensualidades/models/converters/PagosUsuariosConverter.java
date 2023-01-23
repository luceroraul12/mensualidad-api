package ar.my.mensualidades.models.converters;

import ar.my.mensualidades.dto.PagosUsuariosDto;
import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.models.PagosUsuarios;
import ar.my.mensualidades.models.Usuario;

public class PagosUsuariosConverter extends Converter<PagosUsuarios, PagosUsuariosDto>{
    @Override
    public PagosUsuariosDto toDto(PagosUsuarios pagosUsuarios) {
        return new PagosUsuariosDto(
                pagosUsuarios.getId(),
                pagosUsuarios.getUsuario().getId(),
                pagosUsuarios.getPago().getId(),
                pagosUsuarios.getPagoFraccionado());
    }

    @Override
    public PagosUsuarios toEntidad(PagosUsuariosDto pagosUsuariosDto) {
        PagosUsuarios pagosUsuarios = new PagosUsuarios();
        Pago pago = new Pago();
        Usuario usuario = new Usuario();
        usuario.setId(pagosUsuariosDto.getIdUsuario());
        pago.setId(pagosUsuariosDto.getIdPago());

        pagosUsuarios.setId(pagosUsuariosDto.getId());
        pagosUsuarios.setUsuario(usuario);
        pagosUsuarios.setPago(pago);
        pagosUsuarios.setPagoFraccionado(pagosUsuariosDto.getPagoFraccionado());
        return pagosUsuarios;
    }
}
