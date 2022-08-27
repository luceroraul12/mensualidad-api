package ar.my.mensualidades.services;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface MensualidadService {

    List<Factura> getallFacturas();
    List<Pago> getAllPagos();

    /**
     * Busca facturas que han pagado y no pagaron.
     * @param fecha a la que se quiere comprobar. no debe ser null
     * @return conujunto Cargado y No Cargado
     */
    List<Factura> getfacturasCargadasFaltantesByFecha(LocalDate fecha);
    List<Pago> getPagosByFecha(LocalDate fecha);

}
