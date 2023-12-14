package com.futbol.BackendLigaFutbol.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.futbol.BackendLigaFutbol.Entities.*;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    

    List<Partido> findByFecha (@DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date);

    @Query("SELECT partido FROM Partido partido WHERE partido.equipoLocal = ?1 OR partido.equipoVisitante = ?1 ")
    List<Partido> findByEquipoLocalNameOrEquipoVisitanteName(String name);
    
}
