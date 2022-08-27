package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Factura;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FacturaRepositoryTest {

    @Autowired
    FacturaRepository facturaRepository;

    @BeforeEach
    void beforeAll() {

        List<Factura> conjunto = new ArrayList<>();

        conjunto.add(new Factura("Movistar"));
        conjunto.add(new Factura("Carrefour"));
        conjunto.add(new Factura("Megatone"));

        facturaRepository.saveAll(conjunto);

    }

    @Test
    void testCantidadCuardad(){
        int resultado = facturaRepository.findAll().size();

        assertEquals(3, resultado);
    }

    @Test
    void testIdDeServicio(){
        List<Factura> resultado = facturaRepository.findAll();

        assertNotNull(resultado.get(0));
    }

    @Test
    void testIdDeServicioNumero(){
        List<Factura> resultado = facturaRepository.findAll();

        assertEquals(1,resultado.get(0).getId());
    }

}