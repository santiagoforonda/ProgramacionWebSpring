package com.futbol.BackendLigaFutbol.Dtos.ResultadoDtos;


import lombok.Data;

@Data
public class ResultadoDtoCreate {

    private long id;
    private int golVisitante;
    private int golLocal;
    private int nRojas;
    private int nAmarillas;
    private String equipoVisitante;
    private String equipoLocal;
    
    
    
}
