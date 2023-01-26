package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.PorcentajeUsuariosFacturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PorcentajeUsuariosFacturasRepository extends JpaRepository<PorcentajeUsuariosFacturas, Long> {
    @Query("SELECT p FROM PorcentajeUsuariosFacturas p WHERE p.factura.id = :idFactura")
    List<PorcentajeUsuariosFacturas> getPorcentajesPorFactura(Long idFactura);
}