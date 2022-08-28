package ar.my.mensualidades.services;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.response.MensualidadResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface MensualidadService {

    MensualidadResponse getallFacturas();
    MensualidadResponse getAllPagos();

    /**
     * Busca facturas que han pagado y no pagaron.
     * @param fecha a la que se quiere comprobar. no debe ser null
     * @return conujunto Cargado y No Cargado. 0 = Cargado, 1 = Faltante, 2 = CostoTotalPagado
     */
    MensualidadResponse getResumenMensual(LocalDate fecha);

    MensualidadResponse createFactura(Factura factura);
    MensualidadResponse updateFactura(Factura factura);
    MensualidadResponse deleteFactura(Factura factura);
    MensualidadResponse createPago(Pago pago);
    MensualidadResponse updatePago(Pago pago);
    MensualidadResponse deletePago(Pago pago);
}
