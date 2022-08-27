package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}