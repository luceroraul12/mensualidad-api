package ar.my.mensualidades.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ar.my.mensualidades.models.PagosUsuarios} entity
 */
@Data
public class PagosUsuariosDto implements Serializable {
    private final Long id;
    private final UsuarioDto usuario;
    private final PagoDto pago;
    private final Float pagoFraccionado;
}