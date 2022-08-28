package ar.my.mensualidades.services.imp;

import ar.my.mensualidades.response.MensualidadResponse;
import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import ar.my.mensualidades.repositories.FacturaRepository;
import ar.my.mensualidades.repositories.PagoRepository;
import ar.my.mensualidades.services.MensualidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public MensualidadResponse getallFacturas() {
        MensualidadResponse resultado = new MensualidadResponse();
        resultado.setFacturasCreadas(facturaRepository.findAll());
        return resultado;
    }

    @Override
    public MensualidadResponse getAllPagos() {
        MensualidadResponse resultado = new MensualidadResponse();
        resultado.setPagosCreados(pagoRepository.findAll());
        return resultado;
    }

    @Override
    public MensualidadResponse getResumenMensual(LocalDate fecha) {
        MensualidadResponse resultado = new MensualidadResponse();
        List<Factura> facturasTotales = facturaRepository.findAll();
        List<Pago> pagosObtenidos = pagoRepository.buscarPorMesyAño(fecha);
        List<Factura> facturasCargadas;
        List<Factura> facturasFaltantes;

        facturasCargadas = pagosObtenidos.stream().map(Pago::getFactura).collect(Collectors.toList());
        facturasFaltantes = facturasTotales;
        facturasFaltantes.removeAll(facturasCargadas);

        resultado.setFacturasCargadas(facturasCargadas);
        resultado.setFacturasFaltantes(facturasFaltantes);
        resultado.setPagosCargados(pagosObtenidos);
        resultado.setCostoTotalPagado(calcularCosto(pagosObtenidos));
        return resultado;
    }

    @Override
    public MensualidadResponse createFactura(Factura factura) {
        MensualidadResponse resultado = new MensualidadResponse();
        resultado.setFacturaTrabajada(facturaRepository.save(factura));
        return resultado;
    }

    @Override
    public MensualidadResponse updateFactura(Factura factura) {
        MensualidadResponse resultado = new MensualidadResponse();
        resultado.setFacturaTrabajada(facturaRepository.save(factura));
        return resultado;
    }

    @Override
    public MensualidadResponse deleteFactura(Factura factura) {
        MensualidadResponse resultado = new MensualidadResponse();
        Factura facturaGuardada = facturaRepository.findById(factura.getId()).get();
        resultado.setFacturaTrabajada(facturaGuardada);
        facturaRepository.delete(facturaGuardada);
        return resultado;
    }

    @Override
    public MensualidadResponse createPago(Pago pago) {
        MensualidadResponse resultado = new MensualidadResponse();
        resultado.setPagoTrabajado(pagoRepository.save(pago));
        return resultado;
    }

    @Override
    public MensualidadResponse updatePago(Pago pago) {
        MensualidadResponse resultado = new MensualidadResponse();
        resultado.setPagoTrabajado(pagoRepository.save(pago));
        return resultado;
    }

    @Override
    public MensualidadResponse deletePago(Pago pago) {
        MensualidadResponse resultado = new MensualidadResponse();
        Pago pagoGuardado = pagoRepository.findById(pago.getId()).get();
        resultado.setPagoTrabajado(pagoGuardado);
        pagoRepository.delete(pagoGuardado);
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
