package ar.my.mensualidades.models.converters;

import ar.my.mensualidades.dto.UsuarioDto;
import ar.my.mensualidades.models.Usuario;

public class UsuarioConverter extends Converter<Usuario, UsuarioDto>{
    @Override
    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(), usuario.getUsuario());
    }

    @Override
    public Usuario toEntidad(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDto.getId());
        usuario.setUsuario(usuarioDto.getUsuario());
        return usuario;
    }
}
