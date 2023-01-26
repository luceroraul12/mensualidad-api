package ar.my.mensualidades.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ar.my.mensualidades.models.PorcentajeUsuariosFacturas} entity
 */
@Data
public class PorcentajeUsuariosFacturasDto extends Dto implements Serializable {
    private final Long id;
    private final Long idFactura;
    private final Long idUsuario;
    private final String usuario;
    private final Float porcentaje;
}