package ar.my.mensualidades.controllers;

import ar.my.mensualidades.dto.Dto;
import ar.my.mensualidades.models.ModeloMensualidad;
import ar.my.mensualidades.services.MensualidadAbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class CrudAbstractController<Modelo extends ModeloMensualidad, EntidadDto extends Dto> {

    @Autowired
    MensualidadAbstractService<Modelo, EntidadDto> service;


    @PostMapping("crear")
    public ResponseEntity<Object> crear(@RequestBody EntidadDto dto){
        ResponseEntity<Object> respuesta;
        try {
            respuesta = new ResponseEntity<Object>(service.crear(dto),HttpStatus.CREATED);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @PutMapping("modificar")
    public ResponseEntity<Object> modificar(@RequestBody EntidadDto dto){
        ResponseEntity<Object> respuesta;
        try {
            respuesta = new ResponseEntity<Object>(service.modificar(dto),HttpStatus.OK);
        } catch (Exception e) {
            respuesta = new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return respuesta;
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<Object> eliminar(@RequestBody EntidadDto dto){
        ResponseEntity<Object> respuesta;
        try {
            respuesta = new ResponseEntity<Object>(service.eliminar(dto),HttpStatus.OK);
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
