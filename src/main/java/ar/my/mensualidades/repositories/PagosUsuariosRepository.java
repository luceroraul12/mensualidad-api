package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.PagosUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagosUsuariosRepository extends JpaRepository<PagosUsuarios, Long> {
}