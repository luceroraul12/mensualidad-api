package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class MensualidadAbstractService<Entidad extends ModeloMensualidad> implements ActividadesCrud<Entidad>{

    @Autowired
    JpaRepository<Entidad, Long> repository;

    @Override
    public Entidad crear(Entidad modeloMensualidad) throws Exception {
        Entidad elementoCreado =  repository.save(modeloMensualidad);
        if (elementoCreado.getId() <= 0){
            throw new Exception("no se pudo crear");
        }
        return elementoCreado;
    }

    @Override
    public Entidad modificar(Entidad modeloMensualidad) throws Exception {
        Entidad elementoModificado = repository.save(modeloMensualidad);
        if (elementoModificado.getId() <= 0){
            throw new Exception("no se pudo modificar");
        }
        return elementoModificado;
    }

    @Override
    public Entidad eliminar(Entidad modeloMensualidad) throws Exception {
        repository.deleteById(modeloMensualidad.getId());
        if (repository.existsById(modeloMensualidad.getId())){
            throw new Exception("no se pudo eliminar");
        }
        return modeloMensualidad;
    }

    @Override
    public List<Entidad> leer() {
        return repository.findAll();
    }
}
