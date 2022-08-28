package ar.my.mensualidades.response;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import lombok.Data;

import java.util.List;

@Data
public class MensualidadResponse {
    private List<Factura> facturasCreadas;
    private List<Factura> facturasCargadas;
    private List<Factura> facturasFaltantes;
    private List<Pago> pagosCreados;
    private List<Pago> pagosCargados;
    private Double costoTotalPagado;

}
