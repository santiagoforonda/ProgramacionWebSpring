package com.futbol.BackendLigaFutbol.Dtos.ResultadoDtos;

import org.springframework.stereotype.Component;

import com.futbol.BackendLigaFutbol.Entities.Resultado;

@Component
public class ResultadoMapper {

    public ResultadoMapper(){

    }


    public ResultadoDto toDto(Resultado result){
        ResultadoDto resultDto = new ResultadoDto();

        resultDto.setGolLocal(result.getGolLocal());
        resultDto.setGolVisitante(result.getGolVisitante());
        resultDto.setNAmarillas(result.getNAmarillas());
        resultDto.setNRojas(result.getNRojas());
        resultDto.setEquipoLocal(result.getEquipoLocal());
        resultDto.setEquipoVisitante(result.getEquipoVisitante());
        

        return resultDto;
    }

    public Resultado toEntity(ResultadoDto resultDto){
        Resultado result = new Resultado();

        result.setGolLocal(resultDto.getGolLocal());
        result.setGolVisitante(resultDto.getGolVisitante());
        result.setNAmarillas(resultDto.getNAmarillas());
        result.setNRojas(resultDto.getNRojas());
        result.setEquipoLocal(resultDto.getEquipoLocal());
        result.setEquipoVisitante(resultDto.getEquipoVisitante());

        return result;
    }


    public ResultadoDtoCreate toResultCreated(Resultado result){
        ResultadoDtoCreate resultDtoCreated = new ResultadoDtoCreate();
        resultDtoCreated.setId(result.getId());
        resultDtoCreated.setGolLocal(result.getGolLocal());
        resultDtoCreated.setGolVisitante(result.getGolVisitante());
        resultDtoCreated.setNAmarillas(result.getNAmarillas());
        resultDtoCreated.setNRojas(result.getNRojas());
        resultDtoCreated.setEquipoLocal(result.getEquipoLocal());
        resultDtoCreated.setEquipoVisitante(result.getEquipoVisitante());

        return resultDtoCreated;
    }

    public Resultado toResultadoByDtoCreated (ResultadoDtoCreate resultDto){
        Resultado result = new Resultado();

        result.setId(resultDto.getId());
        result.setGolLocal(resultDto.getGolLocal());
        result.setGolVisitante(resultDto.getGolVisitante());
        result.setNAmarillas(resultDto.getNAmarillas());
        result.setNRojas(resultDto.getNRojas());
        result.setEquipoLocal(resultDto.getEquipoLocal());
        result.setEquipoVisitante(resultDto.getEquipoVisitante());
        

        return result;
    }
    
}
