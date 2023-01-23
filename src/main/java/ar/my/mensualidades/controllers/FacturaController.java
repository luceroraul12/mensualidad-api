package ar.my.mensualidades.controllers;

import ar.my.mensualidades.dto.FacturaDto;
import ar.my.mensualidades.models.Factura;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("facturas")
@CrossOrigin
public class FacturaController extends CrudAbstractController<Factura, FacturaDto>{
}
