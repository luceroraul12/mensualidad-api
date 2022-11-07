package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.ModeloMensualidad;
import ar.my.mensualidades.services.MensualidadAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class CrudAbstractController<Modelo extends ModeloMensualidad> {

    @Autowired
    MensualidadAbstractService<Modelo> service;


    @GetMapping("crear")
    public ResponseEntity<Modelo> crear(@RequestBody Modelo modelo){
        ResponseEntity<Modelo> respuesta;
        try {
            respuesta = new ResponseEntity<Modelo>(service.crear(modelo),HttpStatus.CREATED);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @GetMapping("modificar")
    public ResponseEntity<Modelo> modificar(@RequestBody Modelo modelo){
        ResponseEntity<Modelo> respuesta;
        try {
            respuesta = new ResponseEntity<Modelo>(service.modificar(modelo),HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @GetMapping("eliminar")
    public ResponseEntity<Modelo> eliminar(@RequestBody Modelo modelo){
        ResponseEntity<Modelo> respuesta;
        try {
            respuesta = new ResponseEntity<Modelo>(service.eliminar(modelo),HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Modelo>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @GetMapping("leer")
    public ResponseEntity<List<Modelo>> leer(){
        ResponseEntity<List<Modelo>> respuesta;
        try {
            respuesta = new ResponseEntity<List<Modelo>>(service.leer(),HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<List<Modelo>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

}
