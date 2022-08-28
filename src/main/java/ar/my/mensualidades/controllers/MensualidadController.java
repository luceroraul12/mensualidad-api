package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MensualidadController {

    @Autowired
    MensualidadService mensualidadService;

    @GetMapping
    public List<Factura> getAllFacturas(){
        return mensualidadService.getallFacturas();
    }



}
