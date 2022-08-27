package ar.my.mensualidades.repositories;

import ar.my.mensualidades.models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    /**
     * Metodo para obtener los pagos que tengan el mismo mes y año de la fecha ingresada.
     * @param fechaDePago no debe ser null
     * @return conjunto que cumple
     */
    @Query("select p from Pago p where year(p.fechaDePago) = year(:fechaDePago)" +
            "and month(p.fechaDePago) = month(:fechaDePago)")
    List<Pago> buscarPorMesyAño(@Param("fechaDePago") LocalDate fechaDePago);



}