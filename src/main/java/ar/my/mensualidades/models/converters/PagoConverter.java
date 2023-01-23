package ar.my.mensualidades.models.converters;

import ar.my.mensualidades.dto.PagoDto;
import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;

public class PagoConverter extends Converter<Pago, PagoDto>{
    @Override
    PagoDto toDto(Pago pago) {
        return new PagoDto(
                pago.getId(),
                pago.getPago(),
                pago.getFactura().getId(),
                pago.getFechaDePago(),
                pago.getComentario()
        );
    }

    @Override
    Pago toEntidad(PagoDto dto) {
        Pago pago = new Pago();
        Factura factura = new Factura();
        pago.setId(dto.getId());
        pago.setFechaDePago(dto.getFechaDePago());
        pago.setComentario(dto.getComentario());
        pago.setPago(dto.getPago());
        factura.setId(dto.getIdfactura());
        pago.setFactura(factura);
        return pago;
    }
}
