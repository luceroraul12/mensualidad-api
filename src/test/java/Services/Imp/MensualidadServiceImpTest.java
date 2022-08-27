package Services.Imp;

import Controllers.MensualidadController;
import Models.Pago;
import Models.Subscripcion;
import Repositories.PagoRepository;
import Repositories.SubscripcionRepository;
import Services.MensualidadService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class MensualidadServiceImpTest {



    SubscripcionRepository subscripcionRepositoryMock = Mockito.mock(SubscripcionRepository.class);
    PagoRepository pagoRepositoryMock = Mockito.mock(PagoRepository.class);

    @Autowired
    MensualidadService mensualidadService = new MensualidadServiceImp(subscripcionRepositoryMock, pagoRepositoryMock);

    @Autowired
    MensualidadController mensualidadController = new MensualidadController(mensualidadService);




    @BeforeEach
    void beforeAll() {

        List<Subscripcion> conjuntoSubscripciones = new ArrayList<>();
        List<Pago> conjuntoPagos = new ArrayList<>();

        conjuntoSubscripciones.add(new Subscripcion("Movistar"));
        conjuntoSubscripciones.add(new Subscripcion("Carrefour"));
        conjuntoSubscripciones.add(new Subscripcion("Vea"));
        conjuntoSubscripciones.add(new Subscripcion("Electricidad"));

        conjuntoPagos.add(new Pago(2342.34, LocalDate.now(), conjuntoSubscripciones.get(1)));
        conjuntoPagos.add(new Pago(234.34, LocalDate.now(), conjuntoSubscripciones.get(1)));
        conjuntoPagos.add(new Pago(12323.2, LocalDate.now(), conjuntoSubscripciones.get(2)));
        conjuntoPagos.add(new Pago(11.22, LocalDate.now(), conjuntoSubscripciones.get(3)));
        conjuntoPagos.add(new Pago(2435.4, LocalDate.now(), conjuntoSubscripciones.get(3)));




        Mockito.when(subscripcionRepositoryMock.findAll()).thenReturn(conjuntoSubscripciones);
        Mockito.when(pagoRepositoryMock.findAll()).thenReturn(conjuntoPagos);
    }

    @Test
    void getAllSusbscripcionesTest(){
        List<Subscripcion> resultado = mensualidadController.getAllSubs();
        resultado.forEach(subscripcion -> System.out.println(subscripcion));
        Assertions.assertEquals(4, resultado.size());
    }

    @Test
    void getAllPagosTest(){
        List<Pago> resultado = mensualidadController.getAllPagos();
        resultado.forEach(subscripcion -> System.out.println(subscripcion));
        Assertions.assertEquals(5, resultado.size());
    }

}