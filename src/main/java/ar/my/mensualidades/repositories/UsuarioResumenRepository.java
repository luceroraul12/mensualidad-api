package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.UsuarioResumen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioResumenRepository extends JpaRepository<UsuarioResumen, Long> {
}
