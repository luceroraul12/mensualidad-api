package ar.my.mensualidades.services.imp;

import ar.my.mensualidades.response.MensualidadResponse;
import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public MensualidadResponse getfacturasCargadasFaltantesByFecha(LocalDate fecha) {
        List<Factura> facturasTotales = getallFacturas();
        List<Pago> pagosObtenidos = pagoRepository.buscarPorMesyAño(fecha);

        List<Factura> facturasObtenidasDePagos = new ArrayList<>();
        MensualidadResponse resultado = new MensualidadResponse();

        List<Factura> facturasCargadas = new ArrayList<>();
        List<Factura> facturasFaltantes = new ArrayList<>();

        facturasCargadas = pagosObtenidos.stream().map(Pago::getFactura).collect(Collectors.toList());

        facturasFaltantes = facturasTotales;
        facturasFaltantes.removeAll(facturasCargadas);

        resultado.setFacturasCargadas(facturasCargadas);
        resultado.setFacturasFaltantes(facturasFaltantes);
        resultado.setCostoTotalPagado(calcularCosto(pagosObtenidos));
        return resultado;
    }

    private double calcularCosto(List<Pago> pagosObtenidos) {
        double resultado = 0;
        
        for (Pago pago : pagosObtenidos){
            resultado+= pago.getPago();
        }

        return resultado;
    }

}
