package com.futbol.BackendLigaFutbol.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resultados")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Resultado {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private long id;

    @Column
    private int golVisitante;

    @Column
    private int golLocal;

    @Column
    private int nRojas;

    @Column
    private int nAmarillas;

    @Column
    private String equipoVisitante;

    @Column
    private String equipoLocal;

    public Resultado(long id, int golVisitante,int golLocal, int nRojas, int nAmarillas){
        this.id=id;
        this.golVisitante=golVisitante;
        this.golLocal=golLocal;
        this.nRojas=nRojas;
        this.nAmarillas=nAmarillas;
    }
    public Resultado updateWith(Resultado score){
        return new Resultado(this.id,score.golLocal,score.golVisitante,score.nAmarillas,score.nRojas,score.equipoLocal,score.equipoVisitante);
    }
}
