package ar.my.mensualidades.controllers;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.response.MensualidadResponse;
import ar.my.mensualidades.services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("api")
public class MensualidadController {

    @Autowired MensualidadService mensualidadService;
    @Autowired FacturaRepository facturaRepository;
    @Autowired PagoRepository pagoRepository;



    public MensualidadController(MensualidadService mensualidadService) {
        this.mensualidadService = mensualidadService;
    }

    /**
     * Meotodo por el cual se puede obtener todos las facturas creados
     * @return
     */
    @GetMapping("/facturas")
    public MensualidadResponse getAllFacturas(){
        return mensualidadService.getallFacturas();
    }

    @PostMapping("/facturas")
    public ResponseEntity createFactura(@RequestParam("nombre-servicio") String nombreServicio){
        MensualidadResponse resultado = mensualidadService.createFactura(new Factura(nombreServicio));
        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    @PostMapping("/facturas/update")
    public ResponseEntity updateFactura(
            @RequestParam("id") Long id,
            @RequestParam("nombre-servicio") String nombreServicio){

        Factura factura = new Factura();
        factura.setId(id);
        factura.setNombre(nombreServicio);

        MensualidadResponse resultado = mensualidadService.updateFactura(factura);
        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    @DeleteMapping("/facturas/delete")
    public ResponseEntity deleteFactura(@RequestParam("id") Long id){
        Factura factura = new Factura();
        factura.setId(id);
        MensualidadResponse resultado = mensualidadService.deleteFactura(factura);
        return new ResponseEntity(resultado, HttpStatus.OK);
    }
    /**
     * Metodo por el cual se puede obtener todos los pagos creados
     * @return
     */
    @GetMapping("/pagos")
    public MensualidadResponse getAllPagos(){
        return mensualidadService.getAllPagos();
    }
    @PostMapping("/pagos")
    public ResponseEntity createPagos(
            @RequestParam("id-servicio") Long idServicio,
            @RequestParam("costo") Double costoPagado,
            @RequestParam("fecha") String fechaDelPago){

        Factura factura = new Factura();
        factura.setId(idServicio);
        Pago pago = new Pago();
        pago.setPago(costoPagado);
        pago.setFechaDePago(LocalDate.parse(fechaDelPago));
        pago.setFactura(factura);

        MensualidadResponse resultado = mensualidadService.createPago(pago);
        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    @PostMapping("/pagos/update")
    public ResponseEntity updatePago(
            @RequestParam("id-pago") Long idPago,
            @RequestParam("id-factura") Long idFactura,
            @RequestParam("costo") Double costoPagado,
            @RequestParam("fecha") String fechaDelPago){

        Factura factura = new Factura();
        factura.setId(idFactura);
        Pago pago = new Pago();
        pago.setId(idPago);
        pago.setPago(costoPagado);
        pago.setFechaDePago(LocalDate.parse(fechaDelPago));
        pago.setFactura(factura);

        MensualidadResponse resultado = mensualidadService.updatePago(pago);
        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    @DeleteMapping("/pagos/delete")
    public ResponseEntity deletePago(@RequestParam("id") Long id){
        Pago pago = new Pago();
        pago.setId(id);
        MensualidadResponse resultado = mensualidadService.deletePago(pago);
        return new ResponseEntity(resultado, HttpStatus.OK);
    }

    /**
     * Meotodo por el cual se puede obtener un conjunto de resultados / resumen en función a una fecha
     * @param fecha
     * @return Objeto que contiene: facturas cargadas, facturas faltantes, pagos cargados, costo pagado.
     */
    @GetMapping("/mensual")
    public MensualidadResponse getResultadoMesElegido(@RequestParam("fecha") String fecha){
        return mensualidadService.getResumenMensual(LocalDate.parse(fecha));
    }






}
