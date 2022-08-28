package ar.my.mensualidades.controllers;

import ar.my.mensualidades.response.MensualidadResponse;
import ar.my.mensualidades.services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class MensualidadController {

    @Autowired
    MensualidadService mensualidadService;

    public MensualidadController(MensualidadService mensualidadService) {
        this.mensualidadService = mensualidadService;
    }

    @GetMapping("/facturas")
    public MensualidadResponse getAllFacturas(){
        return mensualidadService.getallFacturas();
    }

    @GetMapping("/pagos")
    public MensualidadResponse getAllPagos(){
        return mensualidadService.getAllPagos();
    }

    @GetMapping("/mensual")
    public MensualidadResponse getResultadoMesElegido(@RequestParam("fecha") String fecha){
        return mensualidadService.getResumenMensual(LocalDate.parse(fecha));
    }



}
