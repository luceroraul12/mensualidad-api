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

    public MensualidadServiceImp(FacturaRepository facturaRepository, PagoRepository pagoRepository) {
        this.facturaRepository = facturaRepository;
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Factura> getallFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public List<List<Factura>> getfacturasCargadasFaltantesByFecha(LocalDate fecha) {
        List<Factura> facturasTotales = facturaRepository.findAll();
        List<Pago> pagosObtenidos = pagoRepository.buscarPorMesyAnio(fecha);

        List<Factura> facturasObtenidasDePagos = new ArrayList<>();
        List<List<Factura>> resultado = new ArrayList<>();

        List<Factura> facturasCargadas = new ArrayList<>();
        List<Factura> facturasFaltantes = new ArrayList<>();

        for (Pago p : pagosObtenidos){
            facturasCargadas.add(p.getFactura());
        }

        facturasFaltantes = facturasTotales;
        facturasFaltantes.removeAll(facturasCargadas);

        resultado.add(facturasCargadas);
        resultado.add(facturasFaltantes);

        return resultado;
    }

    @Override
    public List<Pago> getPagosByFecha(LocalDate fecha) {
        return pagoRepository.findByFechaDePago(fecha);
    }
}
