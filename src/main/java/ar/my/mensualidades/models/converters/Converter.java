package ar.my.mensualidades.models.converters;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Converter<Entidad, EntidadDto> {
    public abstract EntidadDto toDto(Entidad entidad);
    public abstract Entidad toEntidad(EntidadDto dto);
    public List<Entidad> toEntidadList(List<EntidadDto> dtos){
        return dtos.stream().map(this::toEntidad).collect(Collectors.toList());
    }
    public List<EntidadDto> toDtoList(List<Entidad> entidades){
        return entidades.stream().map(this::toDto).collect(Collectors.toList());
    }
}
