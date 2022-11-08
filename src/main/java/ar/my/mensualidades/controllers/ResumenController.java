package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.ModeloMensualidad;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.services.FacturaService;
import ar.my.mensualidades.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("resumen")
public class ResumenController {

    @Autowired
    FacturaService facturaService;

    @Autowired
    PagoRepository pagoRepository;

    @PostMapping
    public Map<String, Set<ModeloMensualidad>> obtenerResumen(
            @RequestParam("mes") Integer mes,
            @RequestParam("anio") Integer anio){
        Map<String, Set<ModeloMensualidad>> resumen = facturaService.obtenerResumenFacturas(mes, anio);
        resumen.put("pagosRealizados", new HashSet<>(pagoRepository.obtenerPagosResumenMesyAnio(mes, anio)));
        return resumen;
    }
}
