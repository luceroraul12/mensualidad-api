package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.PorcentajeUsuariosFacturas;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("porcentaje-usuarios-facturas")
@CrossOrigin
public class PorcentajeUsuariosFacturasController extends CrudAbstractController<PorcentajeUsuariosFacturas>{
}
