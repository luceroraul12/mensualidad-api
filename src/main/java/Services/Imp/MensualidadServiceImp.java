package Services.Imp;

import Models.Pago;
import Models.Subscripcion;
import Repositories.PagoRepository;
import Repositories.SubscripcionRepository;
import Services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensualidadServiceImp implements MensualidadService {

    @Autowired
    private SubscripcionRepository subscripcionRepository;

    @Autowired
    private PagoRepository pagoRepository;

    public MensualidadServiceImp(SubscripcionRepository subscripcionRepository, PagoRepository pagoRepository) {
        this.subscripcionRepository = subscripcionRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Subscripcion> getAllSubscripciones(){
        return subscripcionRepository.findAll();
    }

    @Override
    public List<Pago> getAllPagos(){
        return pagoRepository.findAll();
    }




}
