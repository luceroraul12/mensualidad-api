package ar.my.mensualidades.controllers;

import ar.my.mensualidades.dto.PorcentajeUsuariosFacturasDto;
import ar.my.mensualidades.models.PorcentajeUsuariosFacturas;
import ar.my.mensualidades.services.PorcentajeUsuariosFacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("porcentaje-usuarios-facturas")
@CrossOrigin
public class PorcentajeUsuariosFacturasController extends CrudAbstractController<PorcentajeUsuariosFacturas, PorcentajeUsuariosFacturasDto>{
    @Autowired
    private PorcentajeUsuariosFacturasService porcentajeUsuariosFacturasService;

    @GetMapping("leer-factura")
    private List<PorcentajeUsuariosFacturasDto> getPorcentajesPorFactura(@RequestParam Long idFactura){
        return porcentajeUsuariosFacturasService.getPorcentajesPorFactura(idFactura);
    }
}
