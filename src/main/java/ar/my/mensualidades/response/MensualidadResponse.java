package ar.my.mensualidades.response;

import ar.my.mensualidades.models.Factura;
import ar.my.mensualidades.models.Pago;
import lombok.Data;

import java.util.List;

@Data
public class MensualidadResponse {
    private List<Pago> pagosCargados;
    private List<Factura> facturasCargadas;
    private List<Factura> facturasFaltantes;
    private Double costoTotalPagado;

    private List<Factura> facturasCreadas;
    private List<Pago> pagosCreados;

    private Factura facturaTrabajada;
    private Pago pagoTrabajado;

}
