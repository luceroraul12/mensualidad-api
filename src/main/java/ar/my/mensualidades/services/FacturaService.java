package ar.my.mensualidades.services;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.ModeloMensualidad;
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

    public Map<String, Set<ModeloMensualidad>> obtenerResumenFacturas(Integer mes, Integer anio){
        Map<String, Set<ModeloMensualidad>> resumenFacturas = new HashMap<>();
        Set<ModeloMensualidad> facturasTotales = new HashSet<>(leer());
        Set<Pago> pagosRealizados = new HashSet<>(pagoRepository.obtenerPagosResumenMesyAnio(mes, anio));

        Set<ModeloMensualidad> facturasPagadas = pagosRealizados.stream()
                .map(Pago::getFactura).collect(Collectors.toSet());

        facturasTotales.removeAll(facturasPagadas);
        Set<ModeloMensualidad> facturasImpagas = new HashSet<>(facturasTotales);

        resumenFacturas.put("facturasPagadas", facturasPagadas);
        resumenFacturas.put("facturasImpagas", facturasImpagas);

        return resumenFacturas;
    }

}
