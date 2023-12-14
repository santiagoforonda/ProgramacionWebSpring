package com.futbol.BackendLigaFutbol.Excepciones;

public class EquipoNotFound extends RuntimeException{

    String mensaje;

    public EquipoNotFound(){
        super("Equipo no encontrado");
    }

    public EquipoNotFound(String mensaje){
        this.mensaje=mensaje;
    }

    
}
