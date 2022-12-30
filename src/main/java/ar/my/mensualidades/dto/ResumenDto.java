package ar.my.mensualidades.dto;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class ResumenDto {
    private Set<Factura> facturasPagadas;
    private Set<Factura> facturasImpagas;
    private List<Pago> pagosPagados;
}
