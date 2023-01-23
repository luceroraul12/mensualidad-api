package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;

import java.util.List;

public interface ActividadesCrud<Entidad extends ModeloMensualidad, EntidadDto> {

    public Entidad crear(EntidadDto modeloMensualidad) throws Exception;
    public Entidad modificar(EntidadDto modeloMensualidad) throws Exception;
    public Entidad eliminar(EntidadDto modeloMensualidad) throws Exception;
    public List<Entidad> leer();

    public List<EntidadDto> leerDto();

}
