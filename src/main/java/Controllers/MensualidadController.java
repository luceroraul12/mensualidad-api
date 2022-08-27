package Controllers;

import Models.Pago;
import Models.Subscripcion;
import Services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MensualidadController {

    @Autowired
    private MensualidadService mensualidadService;

    public MensualidadController(MensualidadService mensualidadService) {
        this.mensualidadService = mensualidadService;
    }

    public List<Subscripcion> getAllSubs(){
        return this.mensualidadService.getAllSubscripciones();
    }

    public List<Pago> getAllPagos(){
        return this.mensualidadService.getAllPagos();
    }
}
