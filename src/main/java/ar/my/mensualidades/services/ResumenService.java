package ar.my.mensualidades.services;

import ar.my.mensualidades.dto.ResumenDto;
import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ResumenService {
    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    public ResumenDto obtenerResumen(Integer mes, Integer anio){
        ResumenDto resumen;
        List<Pago> pagosRealizados = pagoRepository.obtenerPagosResumenMesyAnio(mes, anio);
        List<Factura> facturasExistentes = facturaRepository.findAll();

        resumen = generarResumen(pagosRealizados, facturasExistentes);
        return  resumen;


    }
    public ResumenDto generarResumen(List<Pago> pagosRealizados, List<Factura> facturasExistentes){
        Set<Factura> facturasPagadas = pagosRealizados.stream()
                .map(Pago::getFactura).collect(Collectors.toSet());;
        Set<Factura> facturasImpagas = facturasExistentes.stream()
                .filter(factura -> !facturasPagadas.contains(factura))
                .collect(Collectors.toSet());
        facturasImpagas.addAll(
                facturasExistentes.stream().filter(Factura::isEsRepetible).collect(Collectors.toSet())
        );

        facturasImpagas = facturasImpagas.stream()
                .sorted(Comparator.comparing(Factura::isEsRepetible))
                .collect(Collectors.toSet());
        return new ResumenDto(facturasPagadas, facturasImpagas, pagosRealizados);
    }
}
