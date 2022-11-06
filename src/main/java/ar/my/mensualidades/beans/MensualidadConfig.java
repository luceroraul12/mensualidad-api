package ar.my.mensualidades.beans;

import ar.my.mensualidades.services.FacturaService;
import ar.my.mensualidades.services.MensualidadAbstractService;
import ar.my.mensualidades.services.PagoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MensualidadConfig {

    @Bean
    public MensualidadAbstractService facturaService(){
        return new FacturaService();
    }

    @Bean
    public MensualidadAbstractService pagoService(){
        return new PagoService();
    }

}
