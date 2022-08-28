package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.response.MensualidadResponse;
import ar.my.mensualidades.services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MensualidadController {

    @Autowired
    MensualidadService mensualidadService;

    @GetMapping("/facturas")
    public List<Factura> getAllFacturas(){
        return mensualidadService.getallFacturas();
    }

    @GetMapping("/pagos")
    public List<Pago> getAllPagos(){
        return mensualidadService.getAllPagos();
    }

    @GetMapping("/mensual")
    public MensualidadResponse getResultadoMesElegido(@RequestParam("fecha") String fecha){

        return mensualidadService.getfacturasCargadasFaltantesByFecha(LocalDate.parse(fecha));
    }



}
