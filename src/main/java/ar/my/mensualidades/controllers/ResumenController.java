package ar.my.mensualidades.controllers;

import ar.my.mensualidades.dto.ResumenDto;
import ar.my.mensualidades.services.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("resumen")
public class ResumenController {

    @Autowired
    ResumenService service;
    @GetMapping
    public ResumenDto obtenerResumen(
            @RequestParam("mes") Integer mes,
            @RequestParam("anio") Integer anio){
        return service.obtenerResumen(mes, anio);
    }
}
