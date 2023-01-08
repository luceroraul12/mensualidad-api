package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController extends CrudAbstractController<Usuario> {
}
