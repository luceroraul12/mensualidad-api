package ar.my.mensualidades.services;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.ModeloMensualidad;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FacturaServiceTest {

    @Autowired
    @Qualifier("facturaService")
    JpaRepository<ModeloMensualidad, Long> repository;

    @Test
    void pruebaInyeccion(){
        repository.save(new Factura());
    }

}