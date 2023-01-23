package ar.my.mensualidades.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ar.my.mensualidades.models.Factura} entity
 */
@Data
public class FacturaDto implements Serializable {
    private final Long id;
    private final String nombre;
    private final String url;
    private final boolean esRepetible;
}