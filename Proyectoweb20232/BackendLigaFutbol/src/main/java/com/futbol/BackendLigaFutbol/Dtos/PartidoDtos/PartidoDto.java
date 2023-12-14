package com.futbol.BackendLigaFutbol.Dtos.PartidoDtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;

@Data
public class PartidoDto {
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate fecha;
    private String estadio;

    private String equipoVisitante;

    private String equipoLocal;

    private String arbitro;
}
