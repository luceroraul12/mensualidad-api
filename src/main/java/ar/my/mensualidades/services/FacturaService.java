package ar.my.mensualidades.services;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacturaService extends MensualidadAbstractService<Factura> {

    @Autowired
    PagoRepository pagoRepository;

    public Map<String, Set<Factura>> obtenerResumenFacturas(Integer mes, Integer anio){
        Map<String, Set<Factura>> resumenFacturas = new HashMap<>();
        Set<Factura> facturasTotales = new HashSet<>(leer());
        Set<Pago> pagosRealizados = new HashSet<>(pagoRepository.obtenerPagosResumenMesyAnio(mes, anio));

        Set<Factura> facturasPagadas = pagosRealizados.stream()
                .map(Pago::getFactura).collect(Collectors.toSet());

        facturasTotales.removeAll(facturasPagadas);
        Set<Factura> facturasImpagas = new HashSet<>(facturasTotales);

        resumenFacturas.put("pagados", facturasPagadas);
        resumenFacturas.put("impagos", facturasImpagas);

        return resumenFacturas;
    }

}
