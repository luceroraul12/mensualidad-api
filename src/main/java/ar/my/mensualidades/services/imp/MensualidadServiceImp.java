package ar.my.mensualidades.services.imp;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MensualidadServiceImp implements MensualidadService {

    @Autowired
    FacturaRepository facturaRepository;
    @Autowired
    PagoRepository pagoRepository;

    @Override
    public List<Factura> getallFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public List<Factura> getfacturasCargadasFaltantesByFecha(LocalDate fecha) {
        List<Factura> facturasTotales = facturaRepository.findAll();
        List<Factura> facturasObtenidasDePagos = new ArrayList<>();

        List<Factura> facturasCargadas;
        List<Factura> facturasFaltantes;

        pagoRepository.findByFechaDePago(fecha).stream().map(pago -> facturasObtenidasDePagos.add(pago.getFactura()));


        facturasCargadas = facturasObtenidasDePagos;

        facturasFaltantes = facturasTotales;
        facturasFaltantes.removeAll(facturasCargadas);



        return null;
    }

    @Override
    public List<Pago> getPagosByFecha(LocalDate fecha) {
        return pagoRepository.findByFechaDePago(fecha);
    }
}
