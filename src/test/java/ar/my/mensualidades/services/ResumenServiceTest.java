package ar.my.mensualidades.services;

import ar.my.mensualidades.dto.ResumenDto;
import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ResumenServiceTest {

    ResumenService service = new ResumenService();

    List<Pago> pagos;
    List<Factura> facturas;

    @BeforeEach
    void before(){
        facturas = Arrays.asList(
                new Factura("Supermercado", null, true),
                new Factura("Tarjeta", null, false),
                new Factura("Agua", null, true),
                new Factura("Municipalidad", null, false),
                new Factura("Telefono", null, false),
                new Factura("Panaderia", null, true)

        );

        pagos = Arrays.asList(
                new Pago(23.24, null, null, facturas.get(0)),
                new Pago(23.24, null, null, facturas.get(1)),
                new Pago(21325.2, null, null, facturas.get(2)),
                new Pago(1235.3, null, null, facturas.get(3)),
                new Pago(153.365, null, null, facturas.get(4)),
                new Pago(153.365, null, null, facturas.get(5))
        );

        Collections.shuffle(pagos);
    }
    @Test
    void generarResumen() {
        ResumenDto resultado = service.generarResumen(pagos, facturas);
        assertEquals(6, resultado.getFacturasPagadas().size());
        assertEquals(3, resultado.getFacturasImpagas().size());

        List<String> facturasImpagas = resultado.getFacturasImpagas().stream()
                .sorted(Comparator.comparing(Factura::getNombre))
                .map(Factura::getNombre)
                .toList();

        assertTrue(facturasImpagas.contains("Supermercado"));
        assertTrue(facturasImpagas.contains("Agua"));
        assertTrue(facturasImpagas.contains("Panaderia"));

        assertEquals("Agua",facturasImpagas.get(0));
        assertEquals("Panaderia",facturasImpagas.get(1));
        assertEquals("Supermercado",facturasImpagas.get(2));

    }
}