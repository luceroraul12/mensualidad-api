package ar.my.mensualidades.services.imp;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.response.MensualidadResponse;
import ar.my.mensualidades.services.MensualidadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MensualidadServiceImpTest {

    FacturaRepository facturaRepositoryMock = Mockito.mock(FacturaRepository.class);
    PagoRepository pagoRepositoryMock = Mockito.mock(PagoRepository.class);

    MensualidadService mensualidadService = new MensualidadServiceImp(facturaRepositoryMock, pagoRepositoryMock);


    @BeforeEach
    void setUp() {
        List<Factura> conjuntoFactura = new ArrayList<>();
        List<Pago> conjuntoPago = new ArrayList<>();

        conjuntoFactura.add(new Factura("Movistar"));
        conjuntoFactura.add(new Factura("Carrefour"));
        conjuntoFactura.add(new Factura("Supercanal"));

        when(facturaRepositoryMock.findAll()).thenReturn(conjuntoFactura);

        conjuntoPago.add(new Pago(200.20, LocalDate.now(), conjuntoFactura.get(0)));
        conjuntoPago.add(new Pago(100.30, LocalDate.now(), conjuntoFactura.get(1)));

        when(pagoRepositoryMock.buscarPorMesyAño(LocalDate.now())).thenReturn(conjuntoPago);
        when(pagoRepositoryMock.findAll()).thenReturn(conjuntoPago);

    }

    @Test
    void getfacturasCargadasFaltantesByFecha() {
        MensualidadResponse resultadoObtenido = mensualidadService.getfacturasCargadasFaltantesByFecha(LocalDate.now());
        List<Factura> conjuntoCargadoEsperado = new ArrayList<>();
        List<Factura> conjuntoFaltanteEsperado = new ArrayList<>();

        conjuntoCargadoEsperado.add(new Factura("Movistar"));
        conjuntoCargadoEsperado.add(new Factura("Carrefour"));
        conjuntoFaltanteEsperado.add(new Factura("Supercanal"));


        assertArrayEquals(conjuntoCargadoEsperado.toArray(), resultadoObtenido.getFacturasCargadas().toArray());
        assertArrayEquals(conjuntoFaltanteEsperado.toArray(), resultadoObtenido.getFacturasFaltantes().toArray());
        assertEquals(300.50, resultadoObtenido.getCostoTotalPagado());
    }
}