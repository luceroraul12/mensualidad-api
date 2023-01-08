package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Porcentualidad;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("porcentualidad")
public class PorcentualidadController extends CrudAbstractController<Porcentualidad>{
}
