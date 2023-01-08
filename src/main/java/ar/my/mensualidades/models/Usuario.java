package ar.my.mensualidades.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends ModeloMensualidad{
    @Column
    private String nombre;
}
