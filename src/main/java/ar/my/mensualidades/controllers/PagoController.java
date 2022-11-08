package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("pagos")
@CrossOrigin
public class PagoController extends CrudAbstractController<Pago>{

    @Autowired
    PagoRepository pagoRepository;

    @PostMapping("resumen")
    public List<Pago> obtenerResumen(
            @RequestParam("mes") Integer mes,
            @RequestParam("anio") Integer anio){
        return pagoRepository.obtenerPagosResumenMesyAnio(mes, anio);
    }
}
