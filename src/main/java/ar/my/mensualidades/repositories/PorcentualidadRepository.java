package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Porcentualidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PorcentualidadRepository extends JpaRepository<Porcentualidad, Long> {
    @Query("select p " +
            "from Porcentualidad p " +
            "where p.usuario.id = :idUsuario " +
            "and p.factura.id = :idFactura")
    List<Porcentualidad> obtenerCoincidenciasPorUsuarioyFactura(@Param("idUsuario") Long idUsuario, @Param("idFactura") Long idFactura);


}
