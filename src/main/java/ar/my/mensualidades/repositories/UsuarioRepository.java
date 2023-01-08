package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
