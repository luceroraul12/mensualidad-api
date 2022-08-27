package Services.Imp;

import Controllers.MensualidadController;
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

        List<Subscripcion> conjunto = new ArrayList<>();
        conjunto.add(new Subscripcion(UUID.randomUUID(),"Movistar"));
        conjunto.add(new Subscripcion(UUID.randomUUID(),"Carrefour"));
        conjunto.add(new Subscripcion(UUID.randomUUID(),"Vea"));
        conjunto.add(new Subscripcion(UUID.randomUUID(),"Electricidad"));



        Mockito.when(subscripcionRepositoryMock.findAll()).thenReturn(conjunto);
    }

    @Test
    void getAllSusbscripcionesTest(){
        List<Subscripcion> resultado = mensualidadController.getAllSubs();
        resultado.forEach(subscripcion -> System.out.println(subscripcion));
        Assertions.assertEquals(4, resultado.size());
    }

}