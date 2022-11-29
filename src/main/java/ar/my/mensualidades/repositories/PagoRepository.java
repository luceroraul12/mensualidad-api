package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    @Query("select p from Pago p where " +
            "year(p.fechaDePago) = :anio " +
            "and month(p.fechaDePago) = :mes " +
            "order by p.fechaDePago, p.factura.nombre")
    List<Pago> obtenerPagosResumenMesyAnio(
            @Param("mes") Integer mes,
            @Param("anio") Integer anio
    );

    





}