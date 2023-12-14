package com.futbol.BackendLigaFutbol.Entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "partidos")

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Partido {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
 
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate fecha;
    
    @Column
    private String estadio;

    @Column
    private String equipoVisitante;

    @Column
    private String equipoLocal;

    
    @Column
    private String arbitro;

    public Partido(long id){
        this.id=id;
    }

    public Partido updateWith(Partido match){
        return new Partido(this.id, match.fecha, match.estadio, match.equipoVisitante, match.equipoLocal, match.arbitro);
    }
    
}
