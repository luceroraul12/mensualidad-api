package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class MensualidadAbstractService {

    @Autowired
    JpaRepository<ModeloMensualidad, Long> repository;





}
