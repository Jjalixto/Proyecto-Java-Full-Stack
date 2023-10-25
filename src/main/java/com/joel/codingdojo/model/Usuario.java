package com.joel.codingdojo.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario extends ModeloBase {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 200)
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8)
    private String password;

    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Programa> createBy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(                                                                                             
    name = "calificaciones", 
    joinColumns = @JoinColumn(name = "usuario_id"), 
    inverseJoinColumns = @JoinColumn(name = "programa_id"))

    private Set<Calificaciones> calificaciones;
}
