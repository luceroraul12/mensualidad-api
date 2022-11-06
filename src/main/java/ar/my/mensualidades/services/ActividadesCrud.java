package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;

import java.util.List;

public interface ActividadesCrud<Entidad extends ModeloMensualidad> {

    public Entidad crear(Entidad modeloMensualidad) throws Exception;
    public Entidad modificar(Entidad modeloMensualidad) throws Exception;
    public Entidad eliminar(Entidad modeloMensualidad) throws Exception;
    public List<Entidad> leer();

}
