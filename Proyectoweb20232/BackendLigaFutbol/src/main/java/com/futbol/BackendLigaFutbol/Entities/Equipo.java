package com.futbol.BackendLigaFutbol.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Equipo {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private long id;
    @NotBlank
    @Column
    private String name;
    @NotBlank
    @Column
    private String bandera;
    @NotBlank
    @Column
    private String director;

    

    public Equipo updateWith(Equipo team){
        return new Equipo(this.id, team.name,team.bandera,team.director);
    }
    
}
