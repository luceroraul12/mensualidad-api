package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.PagosUsuarios;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pagos-usuarios")
@CrossOrigin
public class PagosUsuariosController extends CrudAbstractController<PagosUsuarios>{
}
