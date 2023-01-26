package ar.my.mensualidades.dto;

import lombok.Data;

@Data
public class PorcentajesChartsDto {
    private final String name;
    private final Double number;
    private final Extra extra;
    @Data
    private class Extra {
        private final String code;
    }
}