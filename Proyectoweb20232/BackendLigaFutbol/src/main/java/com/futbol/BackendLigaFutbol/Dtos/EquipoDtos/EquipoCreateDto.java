package com.futbol.BackendLigaFutbol.Dtos.EquipoDtos;



import lombok.Data;

@Data
public class EquipoCreateDto {
    private long id;
    private String name;
    private String bandera;
    private String director;
    
}
