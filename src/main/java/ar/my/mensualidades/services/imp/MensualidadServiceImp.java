package ar.my.mensualidades.services.imp;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.services.MensualidadService;

import java.time.LocalDate;
import java.util.List;

public class MensualidadServiceImp implements MensualidadService {
    @Override
    public List<Factura> getallFacturas() {
        return null;
    }

    @Override
    public List<Pago> getAllPagos() {
        return null;
    }

    @Override
    public List<Factura> getFacturasConySinCargaByFecha(LocalDate fecha) {
        return null;
    }

    @Override
    public List<Pago> getPagosByFecha(LocalDate fecha) {
        return null;
    }
}
