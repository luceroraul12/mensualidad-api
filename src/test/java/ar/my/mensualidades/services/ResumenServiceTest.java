package ar.my.mensualidades.services;

import ar.my.mensualidades.dto.ResumenDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResumenServiceTest {

    @Autowired
    ResumenService service;

    @Test
    void generarResumen() {
        ResumenDto resultado = service.obtenerResumen(11, 2022);

    }
}