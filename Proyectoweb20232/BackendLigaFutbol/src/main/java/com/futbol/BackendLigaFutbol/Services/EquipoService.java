package com.futbol.BackendLigaFutbol.Services;

import java.util.List;
import java.util.Optional;

import com.futbol.BackendLigaFutbol.Entities.Equipo;
public interface EquipoService {
    
    List<Equipo> findAllTeams();

    Optional<Equipo> findTeamById( long id);

    Equipo createTeam( Equipo team);

    Optional<Equipo> updateTeam(long id, Equipo team);

    void deleteTeam(long id);

    Equipo findTeamByName(String name);

    
}
