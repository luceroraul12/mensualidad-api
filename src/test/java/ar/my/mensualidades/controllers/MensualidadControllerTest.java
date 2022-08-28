package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.response.MensualidadResponse;
import ar.my.mensualidades.services.MensualidadService;
import ar.my.mensualidades.services.imp.MensualidadServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MensualidadControllerTest {

    FacturaRepository facturaRepositoryMock = Mockito.mock(FacturaRepository.class);
    PagoRepository pagoRepositoryMock = Mockito.mock(PagoRepository.class);

    MensualidadService mensualidadService = new MensualidadServiceImp(facturaRepositoryMock, pagoRepositoryMock);

    @Autowired
    MensualidadController mensualidadController = new MensualidadController(mensualidadService);


    List<Factura> facturasCreadasEsperadas = new ArrayList<>();
    List<Factura> facturasCargadasEsperadas = new ArrayList<>();
    List<Factura> facturasFaltantesEsperadas = new ArrayList<>();
    List<Pago> pagosCreadosEsperados;
    List<Pago> pagosCargadosEsperados;

    @BeforeEach
    void setUp() {
        List<Factura> conjuntoFactura = new ArrayList<>();
        List<Pago> conjuntoPago = new ArrayList<>();
        pagosCreadosEsperados = new ArrayList<>();
        pagosCargadosEsperados = new ArrayList<>();


        conjuntoFactura.add(new Factura("Movistar"));
        conjuntoFactura.add(new Factura("Carrefour"));
        conjuntoFactura.add(new Factura("Supercanal"));
        facturasCreadasEsperadas.addAll(conjuntoFactura);

        when(facturaRepositoryMock.findAll()).thenReturn(conjuntoFactura);

        conjuntoPago.add(new Pago(200.20, LocalDate.now(), conjuntoFactura.get(0)));
        conjuntoPago.add(new Pago(100.30, LocalDate.now(), conjuntoFactura.get(1)));
        pagosCreadosEsperados.addAll(conjuntoPago);

        when(pagoRepositoryMock.buscarPorMesyAño(LocalDate.now())).thenReturn(conjuntoPago);
        when(pagoRepositoryMock.findAll()).thenReturn(conjuntoPago);
    }

    @Test
    void getAllFacturas() {
        MensualidadResponse resultado = mensualidadController.getAllFacturas();
        assertArrayEquals(facturasCreadasEsperadas.toArray(), resultado.getFacturasCreadas().toArray());
    }

    @Test
    void getAllPagos() {
        MensualidadResponse resultado = mensualidadController.getAllPagos();
        assertArrayEquals(pagosCreadosEsperados.toArray(), resultado.getPagosCreados().toArray());
    }

    @Test
    void getResultadoMesElegido() {
        MensualidadResponse respuesta = mensualidadController.getResultadoMesElegido(String.valueOf(LocalDate.now()));
        facturasCreadasEsperadas.remove(2);
        assertArrayEquals(facturasCreadasEsperadas.toArray(), respuesta.getFacturasCargadas().toArray());
        assertArrayEquals(pagosCreadosEsperados.toArray(), respuesta.getPagosCargados().toArray());
        assertEquals(300.50, respuesta.getCostoTotalPagado());
    }

}