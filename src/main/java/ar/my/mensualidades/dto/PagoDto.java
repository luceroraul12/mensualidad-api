package ar.my.mensualidades.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link ar.my.mensualidades.models.Pago} entity
 */
@Data
public class PagoDto implements Serializable {
    private final Long id;
    private final Double pago;
    private final Long idfactura;
    private final LocalDate fechaDePago;
    private final String comentario;
}