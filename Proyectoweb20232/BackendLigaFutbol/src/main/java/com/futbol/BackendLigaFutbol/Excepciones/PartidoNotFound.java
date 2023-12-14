package com.futbol.BackendLigaFutbol.Excepciones;

public class PartidoNotFound extends RuntimeException {

    String mensaje;

    public PartidoNotFound(){
        super("Equipo no encontrado");
    }

    public PartidoNotFound(String mensaje){
        this.mensaje=mensaje;
    }

    
}
