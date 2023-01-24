package ar.my.mensualidades.services;

import ar.my.mensualidades.dto.Dto;
import ar.my.mensualidades.models.ModeloMensualidad;
import ar.my.mensualidades.models.converters.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class MensualidadAbstractService<Entidad extends ModeloMensualidad, EntidadDto extends Dto> implements ActividadesCrud<Entidad, EntidadDto>{

    @Autowired
    protected Converter<Entidad, EntidadDto> converter;

    @Autowired
    JpaRepository<Entidad, Long> repository;

    @Override
    public EntidadDto crear(EntidadDto dto) throws Exception {
        dto.setId(null);
        EntidadDto elementoCreado =  converter.toDto(repository.save(converter.toEntidad(dto)));
        if (elementoCreado.getId() <= 0){
            throw new Exception("no se pudo crear");
        }
        return elementoCreado;
    }

    @Override
    public EntidadDto modificar(EntidadDto dto) throws Exception {
        EntidadDto elementoModificado = converter.toDto(repository.save(converter.toEntidad(dto)));
        if (elementoModificado.getId() <= 0){
            throw new Exception("no se pudo modificar");
        }
        return elementoModificado;
    }

    @Override
    public EntidadDto eliminar(EntidadDto dto) throws Exception {
        repository.deleteById(dto.getId());
        if (repository.existsById(dto.getId())){
            throw new Exception("no se pudo eliminar");
        }
        return dto;
    }

    @Override
    public List<EntidadDto> leer() {
        return converter.toDtoList(repository.findAll());
    }

}
