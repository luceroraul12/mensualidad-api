package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PagoRepositoryTest {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    PagoRepository pagoRepository;

    @BeforeEach
    void beforeEach(){

        List<Factura> conjuntoFacturas = new ArrayList<>();
        List<Pago> conjuntoPagos = new ArrayList<>();

        conjuntoFacturas.add(new Factura("Movistar"));
        conjuntoFacturas.add(new Factura("Carrefour"));
        conjuntoFacturas.add(new Factura("Megatone"));

        facturaRepository.saveAll(conjuntoFacturas);


        conjuntoPagos.add(new Pago(234.34, LocalDate.now(), conjuntoFacturas.get(0)));
        conjuntoPagos.add(new Pago(234.34, LocalDate.of(2022,9,23), conjuntoFacturas.get(0)));
        conjuntoPagos.add(new Pago(234.34, LocalDate.of(2022,5,20), conjuntoFacturas.get(0)));

        pagoRepository.saveAll(conjuntoPagos);

    }

    @Test
    void testTraerTodos(){
        int resultado = pagoRepository.findAll().size();
        assertEquals(3,resultado);
    }

    @Test
    void traerPagosPorMesyAño(){
        List<Pago> resultado = pagoRepository.buscarPorMesyAnio(LocalDate.now());

        assertEquals(1, resultado.size());
    }

    @Test
    void traerPagosPorMesyAñoMal(){
        List<Pago> resultado = pagoRepository.buscarPorMesyAnio(LocalDate.of(2024,12,20));

        assertEquals(0, resultado.size());
    }
}