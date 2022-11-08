package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.PagoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PagoControllerTest {

    @Autowired
    PagoRepository pagoRepository;

    @Test
    void obtenerResumen() {
        LocalDate fechaElegida = LocalDate.of(2022, 11,23);
        List<Pago> resultado = pagoRepository.obtenerPagosResumenMesyAnio(
                fechaElegida.getMonthValue(),
                fechaElegida.getYear()
        );

        assertEquals(3,resultado.size());
    }

    @Test
    void testearFecha(){
        Pago pago = pagoRepository.findAll().get(0);
        LocalDate fechaElegida = LocalDate.of(2022, 11,13);
        assertEquals(fechaElegida, pago.getFechaDePago());

    }
}