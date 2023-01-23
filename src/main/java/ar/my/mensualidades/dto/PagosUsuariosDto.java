package ar.my.mensualidades.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ar.my.mensualidades.models.PagosUsuarios} entity
 */
@Data
public class PagosUsuariosDto extends Dto implements Serializable {
    private final Long id;
    private final Long idUsuario;
    private final Long idPago;
    private final Float pagoFraccionado;
}