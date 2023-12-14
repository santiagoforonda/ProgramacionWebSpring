package com.futbol.BackendLigaFutbol.Services.Implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futbol.BackendLigaFutbol.Entities.Partido;
import com.futbol.BackendLigaFutbol.Repositories.PartidoRepository;
import com.futbol.BackendLigaFutbol.Services.PartidosService;

@Service
public class PartidoServiceImpl implements PartidosService{

    private final PartidoRepository partidoRepo;

    public PartidoServiceImpl(PartidoRepository partiRepo){
        this.partidoRepo=partiRepo;
    }

    @Override
    public List<Partido> findall(){
        return partidoRepo.findAll();
    }
    @Override
    public List<Partido> findPartidosByFecha( @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy") LocalDate fecha) {
        return partidoRepo.findByFecha(fecha);
    }



    @Override
    public Optional<Partido> findPartidoById(long id) {
        
        return partidoRepo.findById(id);
        
    }

    @Override
    public Partido createPartido(Partido partido) {
        Partido partidoCopy= new Partido();
        partidoCopy.setEstadio(partido.getEstadio());
        partidoCopy.setFecha(partido.getFecha());
        partidoCopy.setArbitro(partido.getArbitro());
        partidoCopy.setEquipoLocal(partido.getEquipoLocal());
        partidoCopy.setEquipoVisitante(partido.getEquipoVisitante());
        return partidoRepo.save(partidoCopy);
    }

    @Override
    public Optional<Partido> updatePartido(long id, Partido newMatch) {
        Optional<Partido> partidoInDB = partidoRepo.findById(id);
        Optional<Partido> matchUpdate = partidoInDB.map(oldMatchInDB->{
            Partido partidoAux = oldMatchInDB.updateWith(newMatch);
            return partidoRepo.save(partidoAux);
        });
        return matchUpdate;
        
    }

    @Override
    public List<Partido> findPartidosByTeam(String name) {
        List<Partido> partidos =  partidoRepo.findByEquipoLocalNameOrEquipoVisitanteName(name);
        return partidos;
    }

    @Override
    public boolean findMatchById(long id) {
        
        return partidoRepo.existsById(id);
    }


    
}
