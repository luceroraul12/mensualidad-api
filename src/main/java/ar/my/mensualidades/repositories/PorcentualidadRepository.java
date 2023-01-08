package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Porcentualidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PorcentualidadRepository extends JpaRepository<Porcentualidad, Long> {
}
