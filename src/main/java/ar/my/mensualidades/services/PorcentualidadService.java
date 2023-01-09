package ar.my.mensualidades.services;

import ar.my.mensualidades.models.Porcentualidad;
import ar.my.mensualidades.repositories.PorcentualidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcentualidadService extends MensualidadAbstractService<Porcentualidad>{

    @Autowired
    PorcentualidadRepository porcentualidadRepository;

    @Override
    public Porcentualidad crear(Porcentualidad modeloMensualidad) throws Exception {
        if (cumplePorcentualidadParaCrear(modeloMensualidad)){
            return super.crear(modeloMensualidad);
        } else {
            throw new Exception("La suma de porcentualidad es mayor a 100%");
        }
    }

    @Override
    public Porcentualidad modificar(Porcentualidad modeloMensualidad) throws Exception {
        if (cumplePorcentualidadParaModificar(modeloMensualidad)){
            return super.modificar(modeloMensualidad);
        } else {
            throw new Exception("La suma de porcentualidad es mayor a 100%");
        }
    }

    private boolean cumplePorcentualidadParaModificar(Porcentualidad porcentualidad) {
        List<Porcentualidad> porcentualidadAlmacenada = porcentualidadRepository.obtenerCoincidenciasPorFactura(
                porcentualidad.getFactura().getId()
        );
        Double porcentajes = porcentualidadAlmacenada
                .stream()
                .map(Porcentualidad::getPorcentaje)
                .reduce(Double::sum)
                .get();
        porcentajes+=porcentualidad.getPorcentaje();
        return porcentajes <= 100;
    }

    public boolean cumplePorcentualidadParaCrear(Porcentualidad porcentualidad) throws Exception {
        List<Porcentualidad> porcentualidadAlmacenada = porcentualidadRepository.obtenerCoincidenciasPorUsuarioyFactura(
                porcentualidad.getUsuario().getId(),
                porcentualidad.getFactura().getId()
        );
        if(porcentualidadAlmacenada.isEmpty()){
            return porcentualidad.getPorcentaje() <= 100;
        } else {
            throw new Exception("Ya existe porcentualidad para dicho servicio y usuario");
        }
    }
}
