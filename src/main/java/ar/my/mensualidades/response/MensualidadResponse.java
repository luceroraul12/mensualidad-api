package ar.my.mensualidades.response;

import ar.my.mensualidades.models.Factura;
import lombok.Data;

import java.util.List;

@Data
public class MensualidadResponse {

    private List<Factura> facturasCargadas;
    private List<Factura> facturasFaltantes;
    private Double costoTotalPagado;

}
