package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.UsuarioCosto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios/costos/")
public class UsuarioCostoController extends CrudAbstractController<UsuarioCosto> {
}
