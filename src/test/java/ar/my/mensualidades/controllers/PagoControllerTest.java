package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.PagoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PagoControllerTest {

    @MockBean
    PagoRepository pagoRepository;

    @BeforeEach
    void beforeAll() {
        List<Factura> facturas = Arrays.asList(
                Factura.builder().nombre("movistar").url("asdfasdf").build(),
                Factura.builder().nombre("naranja").url("asdfasdf").build(),
                Factura.builder().nombre("carrefour").url("asdfasdf").build(),
                Factura.builder().nombre("Vea").url("asdfasdf").build()
        );

        List<Pago> pagos = Arrays.asList(
                Pago.builder().pago(23434.34).fechaDePago(LocalDate.of(2022,11,02)).factura(facturas.get(0)).build(),
                Pago.builder().pago(23434.34).fechaDePago(LocalDate.of(2022,11,02)).factura(facturas.get(1)).build(),
                Pago.builder().pago(23434.34).fechaDePago(LocalDate.of(2022,11,02)).factura(facturas.get(1)).build()
        );

        Mockito.when(pagoRepository.obtenerPagosResumenMesyAnio(11,2022))
                .thenReturn(pagos);

        Mockito.when(pagoRepository.findAll())
                .thenReturn(pagos);


    }

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
        LocalDate fechaElegida = LocalDate.of(2022, 11,02);
        assertEquals(fechaElegida, pago.getFechaDePago());

    }
}