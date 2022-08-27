package ar.my.mensualidades.services.imp;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.services.MensualidadService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

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

        conjuntoPago.add(new Pago(234.23, LocalDate.now(), conjuntoFactura.get(0)));
        conjuntoPago.add(new Pago(12323.23, LocalDate.now(), conjuntoFactura.get(1)));

        when(pagoRepositoryMock.buscarPorMesyAnio(LocalDate.now())).thenReturn(conjuntoPago);
        when(pagoRepositoryMock.findAll()).thenReturn(conjuntoPago);

    }

    @Test
    void getfacturasCargadasFaltantesByFecha() {
        List<List<Factura>> resultadoObtenido = mensualidadService.getfacturasCargadasFaltantesByFecha(LocalDate.now());
        List<Factura> conjuntoCargadoEsperado = new ArrayList<>();
        List<Factura> conjuntoFaltanteEsperado = new ArrayList<>();

        conjuntoCargadoEsperado.add(new Factura("Movistar"));
        conjuntoCargadoEsperado.add(new Factura("Carrefour"));
        conjuntoFaltanteEsperado.add(new Factura("Supercanal"));


        assertArrayEquals(conjuntoCargadoEsperado.toArray(), resultadoObtenido.get(0).toArray());
        assertArrayEquals(conjuntoFaltanteEsperado.toArray(), resultadoObtenido.get(1).toArray());
    }
}