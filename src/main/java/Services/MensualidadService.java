package Services;

import Models.Pago;
import Models.Subscripcion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MensualidadService {


    List<Subscripcion> getAllSubscripciones();
    List<Pago> getAllPagos();

}
