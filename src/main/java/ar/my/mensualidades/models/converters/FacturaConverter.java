package ar.my.mensualidades.models.converters;

import ar.my.mensualidades.dto.FacturaDto;
import ar.my.mensualidades.models.Factura;

public class FacturaConverter extends Converter<Factura, FacturaDto>{
    @Override
    FacturaDto toDto(Factura factura) {
        return new FacturaDto(factura.getId(), factura.getNombre(), factura.getUrl(), factura.isEsRepetible());
    }

    @Override
    Factura toEntidad(FacturaDto dto) {
        Factura factura = new Factura();
        factura.setId(dto.getId());
        factura.setNombre(dto.getNombre());
        factura.setUrl(dto.getUrl());
        factura.setEsRepetible(dto.isEsRepetible());
        return factura;
    }
}
