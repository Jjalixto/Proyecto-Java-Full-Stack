package com.joel.codingdojo.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "programas")
@Getter
@Setter
public class Programa extends ModeloBase {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    private String title;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    private String red;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 1000)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(                
    name = "calificaciones", 
    joinColumns = @JoinColumn(name = "programa_id"), //lanza
    inverseJoinColumns = @JoinColumn(name = "usuario_id")) //obtiene

    private Set<Calificaciones> calificaciones; //set para un atributo 


    public float getPromedioCal(Set<Calificaciones> calificaciones){
        float sum = 0;
        for (Calificaciones calificacion : calificaciones) {
            sum += calificacion.getRating();
        }
        float result = sum / calificaciones.size();
        return result;
    }

}
