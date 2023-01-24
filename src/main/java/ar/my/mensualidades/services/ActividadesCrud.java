package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;

import java.util.List;

public interface ActividadesCrud<Entidad extends ModeloMensualidad, EntidadDto> {

    public EntidadDto crear(EntidadDto modeloMensualidad) throws Exception;
    public EntidadDto modificar(EntidadDto modeloMensualidad) throws Exception;
    public EntidadDto eliminar(EntidadDto modeloMensualidad) throws Exception;
    public List<EntidadDto> leer();
}
