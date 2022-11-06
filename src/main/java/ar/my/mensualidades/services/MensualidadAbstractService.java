package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class MensualidadAbstractService implements ActividadesCrud{

    @Autowired
    JpaRepository<ModeloMensualidad, Long> repository;

    @Override
    public ModeloMensualidad crear(ModeloMensualidad modeloMensualidad) throws Exception {
        ModeloMensualidad elementoCreado = repository.save(modeloMensualidad);
        if (elementoCreado.getId() <= 0){
            throw new Exception("no se pudo crear");
        }
        return elementoCreado;
    }

    @Override
    public ModeloMensualidad modificar(ModeloMensualidad modeloMensualidad) throws Exception {
        ModeloMensualidad elementoModificado = repository.save(modeloMensualidad);
        if (elementoModificado.getId() <= 0){
            throw new Exception("no se pudo modificar");
        }
        return elementoModificado;
    }

    @Override
    public ModeloMensualidad eliminar(ModeloMensualidad modeloMensualidad) throws Exception {
        repository.deleteById(modeloMensualidad.getId());
        if (repository.existsById(modeloMensualidad.getId())){
            throw new Exception("no se pudo eliminar");
        }
        return modeloMensualidad;
    }

    @Override
    public List<ModeloMensualidad> leer() {
        return repository.findAll();
    }
}
