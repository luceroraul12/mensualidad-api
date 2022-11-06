package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;

import java.util.List;

public interface ActividadesCrud {

    public ModeloMensualidad crear(ModeloMensualidad modeloMensualidad) throws Exception;
    public ModeloMensualidad modificar(ModeloMensualidad modeloMensualidad) throws Exception;
    public ModeloMensualidad eliminar(ModeloMensualidad modeloMensualidad) throws Exception;
    public List<ModeloMensualidad> leer();

}
