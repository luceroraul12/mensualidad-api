package ar.my.mensualidades.controllers;

import ar.my.mensualidades.dto.PagoDto;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pagos")
@CrossOrigin
public class PagoController extends CrudAbstractController<Pago, PagoDto>{

    @Autowired
    PagoRepository pagoRepository;

}
