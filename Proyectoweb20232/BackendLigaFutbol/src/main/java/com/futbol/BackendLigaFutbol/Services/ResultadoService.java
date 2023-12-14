package com.futbol.BackendLigaFutbol.Services;

import java.util.List;
import java.util.Optional;


import com.futbol.BackendLigaFutbol.Entities.Resultado;

public interface ResultadoService {
    Resultado createResultado( Resultado resultado);
    Optional<Resultado> findResultadoById(long id);
    Optional<Resultado> updateResultado(long id, Resultado resultado);
    List<Resultado> findAllScores();
    
}
