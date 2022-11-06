package ar.my.mensualidades.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudAbstractController<Modelo> {


    public ResponseEntity<Modelo> crear(@RequestBody Modelo modelo){
        ResponseEntity<Modelo> respuesta;



    }



}
