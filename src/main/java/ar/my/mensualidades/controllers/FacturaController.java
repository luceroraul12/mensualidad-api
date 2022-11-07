package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Factura;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("facturas")
public class FacturaController extends CrudAbstractController<Factura>{
}
