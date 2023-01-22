package ar.my.mensualidades.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario extends ModeloMensualidad{
    @Column
    private String nombre;
}
