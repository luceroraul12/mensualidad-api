package ar.my.mensualidades.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Usuario extends ModeloMensualidad{
    @Column
    private String nombre;
}
