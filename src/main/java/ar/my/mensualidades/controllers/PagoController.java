package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Pago;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagos")
public class PagoController extends CrudAbstractController<Pago>{
}
