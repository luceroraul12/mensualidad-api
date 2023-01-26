package ar.my.mensualidades.models.converters;

import ar.my.mensualidades.dto.PorcentajesChartsDto;
import ar.my.mensualidades.models.PorcentajeUsuariosFacturas;
import org.springframework.stereotype.Service;

@Service
public class PorcentajesChartsConverter extends Converter<PorcentajeUsuariosFacturas, PorcentajesChartsDto> {
    @Override
    public PorcentajesChartsDto toDto(PorcentajeUsuariosFacturas entidad) {
        return new PorcentajesChartsDto(
                entidad.getUsuario().getUsuario(),
                entidad.getPorcentaje(),
                new PorcentajesChartsDto.Extra(entidad.getUsuario().getUsuario()));
    }

    @Override
    public PorcentajeUsuariosFacturas toEntidad(PorcentajesChartsDto dto) {
        return null;
    }
}
