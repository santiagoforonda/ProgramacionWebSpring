package com.futbol.BackendLigaFutbol.Dtos.EquipoDtos;

import org.springframework.stereotype.Component;
import com.futbol.BackendLigaFutbol.Entities.*;

@Component
public class EquipoMapper {
    public EquipoMapper(){

    }

    public EquipoDto toDto(Equipo team){
        EquipoDto equipoDto = new EquipoDto();

        equipoDto.setName(team.getName());
        equipoDto.setDirector(team.getDirector());
        equipoDto.setBandera(team.getBandera());
       
        return equipoDto;
    }

    public Equipo toEntity(EquipoDto teamDto){
        Equipo equipo= new Equipo();
        equipo.setName(teamDto.getName());
        equipo.setDirector(teamDto.getDirector());
        equipo.setBandera(teamDto.getBandera());
        

        return equipo;
    }

    public EquipoCreateDto toEquipoCreate(Equipo team){
        EquipoCreateDto teamCreateDto= new EquipoCreateDto();

        teamCreateDto.setId(team.getId());
        teamCreateDto.setName(team.getName());
        teamCreateDto.setDirector(team.getDirector());
        teamCreateDto.setBandera(team.getBandera());
        

        return teamCreateDto;
    }

    public Equipo toEquipoByDtoCreated (EquipoCreateDto teamCreated){

        Equipo equipo= new Equipo();
        equipo.setId(teamCreated.getId());
        equipo.setName(teamCreated.getName());
        equipo.setDirector(teamCreated.getDirector());
        equipo.setBandera(teamCreated.getBandera());
        
        return equipo;
    }


    
}
