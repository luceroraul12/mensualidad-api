package ar.my.mensualidades.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "facturas")
public class Factura extends ModeloMensualidad{

    @Column
    private String nombre;

    @Column
    private String url;

    @Column
    private boolean esRepetible;

}