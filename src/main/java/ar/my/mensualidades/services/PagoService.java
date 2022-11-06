package ar.my.mensualidades.services;

import ar.my.mensualidades.models.ModeloMensualidad;
import ar.my.mensualidades.models.Pago;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PagoService extends MensualidadAbstractService<Pago> {


}
