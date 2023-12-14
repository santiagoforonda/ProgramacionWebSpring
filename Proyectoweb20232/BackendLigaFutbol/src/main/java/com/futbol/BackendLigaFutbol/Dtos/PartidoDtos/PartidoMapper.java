package com.futbol.BackendLigaFutbol.Dtos.PartidoDtos;

import org.springframework.stereotype.Component;

import com.futbol.BackendLigaFutbol.Entities.Partido;

@Component
public class PartidoMapper {
    public PartidoMapper(){

    }
    


    public PartidoDto toDto(Partido match){
        PartidoDto partidoDto = new PartidoDto();

        partidoDto.setArbitro(match.getArbitro());
       partidoDto.setFecha(match.getFecha());
        partidoDto.setEstadio(match.getEstadio());
        partidoDto.setEquipoLocal(match.getEquipoLocal());
        partidoDto.setEquipoVisitante(match.getEquipoVisitante());

        return partidoDto;
    }

    public Partido toEntity (PartidoDto matchDto){
        Partido partido = new Partido();

        partido.setArbitro(matchDto.getArbitro());
        partido.setFecha(matchDto.getFecha());
        partido.setEstadio(matchDto.getEstadio());
        partido.setEquipoLocal(matchDto.getEquipoLocal());
        partido.setEquipoVisitante(matchDto.getEquipoVisitante());
        

        return partido;

    }

    public PartidoDtoCreate toPartidoCreate(Partido partido){

        PartidoDtoCreate matchDtoCreated = new PartidoDtoCreate();

        matchDtoCreated.setId(partido.getId());
        
        matchDtoCreated.setEstadio(partido.getEstadio());
        
        matchDtoCreated.setEquipoVisitante(partido.getEquipoVisitante());
        
        matchDtoCreated.setEquipoLocal(partido.getEquipoLocal());
        matchDtoCreated.setFecha(partido.getFecha());
        matchDtoCreated.setArbitro(partido.getArbitro());

        return matchDtoCreated;
    }



    public Partido toPartidoByDtoCreated(PartidoDtoCreate matchCreated){
        Partido match = new Partido();

        match.setId(matchCreated.getId());
       
       match.setEstadio(matchCreated.getEstadio());
       match.setEquipoVisitante(matchCreated.getEquipoVisitante());
       match.setEquipoLocal(matchCreated.getEquipoLocal());
       match.setArbitro(matchCreated.getArbitro());
        match.setFecha(matchCreated.getFecha());

        return match;
    }
}
