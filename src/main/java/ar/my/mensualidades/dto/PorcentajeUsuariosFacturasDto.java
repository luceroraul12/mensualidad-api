package ar.my.mensualidades.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ar.my.mensualidades.models.PorcentajeUsuariosFacturas} entity
 */
@Data
public class PorcentajeUsuariosFacturasDto implements Serializable {
    private final Long id;
    private final Long idFactura;
    private final Long idUsuario;
    private final Float porcentaje;
}