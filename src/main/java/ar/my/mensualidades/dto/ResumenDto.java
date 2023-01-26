package ar.my.mensualidades.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResumenDto {
    private List<FacturaDto> facturasPagadas;
    private List<FacturaDto> facturasImpagas;
    private List<PagoDto> pagosPagados;
}
