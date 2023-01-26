package ar.my.mensualidades.services;

import ar.my.mensualidades.dto.PorcentajeUsuariosFacturasDto;
import ar.my.mensualidades.models.PorcentajeUsuariosFacturas;
import ar.my.mensualidades.models.converters.PorcentajeUsuariosFacturasConverter;
import ar.my.mensualidades.repositories.PorcentajeUsuariosFacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcentajeUsuariosFacturasService extends MensualidadAbstractService<PorcentajeUsuariosFacturas, PorcentajeUsuariosFacturasDto>{

    @Autowired
    private PorcentajeUsuariosFacturasRepository porcentajeUsuariosFacturasRepository;

    @Autowired
    private PorcentajeUsuariosFacturasConverter porcentajeUsuariosFacturasConverter;

    public List<PorcentajeUsuariosFacturasDto> getPorcentajesPorFactura(Long idFactura) {
        return porcentajeUsuariosFacturasConverter.toDtoList(porcentajeUsuariosFacturasRepository.getPorcentajesPorFactura(idFactura));
    }
}
