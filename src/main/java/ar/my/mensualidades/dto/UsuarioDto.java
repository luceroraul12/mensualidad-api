package ar.my.mensualidades.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ar.my.mensualidades.models.Usuario} entity
 */
@Data
public class UsuarioDto implements Serializable {
    private final Long id;
    private final String usuario;
}