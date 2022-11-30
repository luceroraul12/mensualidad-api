package ar.my.mensualidades.services;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.ModeloMensualidad;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FacturaServiceTest {

    @MockBean
    PagoRepository pagoRepository;

    @MockBean
    FacturaRepository facturaRepository;

//    @InjectMocks
    @Autowired
    FacturaService facturaService;

    @BeforeEach
    void seteables(){

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
//            Pago.builder().pago(23434.34).fechaDePago(LocalDate.of(2022,11,02)).factura(facturas.get(2)).build()
        );

        Mockito.when(pagoRepository.obtenerPagosResumenMesyAnio(11,2022))
                .thenReturn(pagos);
        Mockito.when(facturaRepository.findAll()).thenReturn(facturas);
    }

    @Test
    void probarResumen(){
        Map<String, Set<ModeloMensualidad>> resumen = facturaService.obtenerResumenFacturas(11,2022);

        assertEquals(2, resumen.get("facturasPagadas").size());
        assertEquals(2, resumen.get("facturasImpagas").size());


    }

}