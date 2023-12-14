package com.futbol.BackendLigaFutbol.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futbol.BackendLigaFutbol.Entities.*;
public interface PartidosService {
    List<Partido> findPartidosByFecha ( @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy") LocalDate fecha);
    List<Partido> findPartidosByTeam(String name);
    Optional<Partido> findPartidoById(long id);
    boolean findMatchById(long id);
    Partido createPartido( Partido partido);
    Optional<Partido> updatePartido(long id, Partido newMatch);
    List<Partido> findall();
    
}
