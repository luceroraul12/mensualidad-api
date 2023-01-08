package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.ModeloMensualidad;
import ar.my.mensualidades.services.MensualidadAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudAbstractController<Modelo extends ModeloMensualidad> {

    @Autowired
    MensualidadAbstractService<Modelo> service;


    @PostMapping("crear")
    public ResponseEntity<Object> crear(@RequestBody Modelo modelo){
        ResponseEntity<Object> respuesta;
        try {
            respuesta = new ResponseEntity<Object>(service.crear(modelo),HttpStatus.CREATED);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @PutMapping("modificar")
    public ResponseEntity<Object> modificar(@RequestBody Modelo modelo){
        ResponseEntity<Object> respuesta;
        try {
            respuesta = new ResponseEntity<Object>(service.modificar(modelo),HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Object> eliminar(@RequestBody Modelo modelo){
        ResponseEntity<Object> respuesta;
        try {
            respuesta = new ResponseEntity<Object>(service.eliminar(modelo),HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @GetMapping("leer")
    public ResponseEntity<Object> leer(){
        ResponseEntity<Object> respuesta;
        try {
            respuesta = new ResponseEntity<Object>(service.leer(),HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

}
