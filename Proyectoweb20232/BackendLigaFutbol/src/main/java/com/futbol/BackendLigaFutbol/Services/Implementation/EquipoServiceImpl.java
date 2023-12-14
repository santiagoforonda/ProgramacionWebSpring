package com.futbol.BackendLigaFutbol.Services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.futbol.BackendLigaFutbol.Entities.Equipo;
import com.futbol.BackendLigaFutbol.Repositories.EquipoRepository;
import com.futbol.BackendLigaFutbol.Services.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService{


    private final EquipoRepository equipoRepository;

    public EquipoServiceImpl(EquipoRepository equipoRepository){
        this.equipoRepository=equipoRepository;
    }

    @Override
    public List<Equipo> findAllTeams() {
        return equipoRepository.findAll();
    }

    @Override
    public Optional<Equipo> findTeamById(long id) {
        return equipoRepository.findById(id);
        
    }

    @Override
    public Equipo createTeam(Equipo team) {
        Equipo equipoCopy = new Equipo();
        equipoCopy.setName(team.getName());
        equipoCopy.setDirector(team.getDirector());
        equipoCopy.setBandera(team.getBandera());
        return equipoRepository.save(equipoCopy);
    }

    @Override
    public Optional<Equipo> updateTeam(long id, Equipo team) {
        Optional<Equipo> equipoInDB = equipoRepository.findById(id);
        Optional<Equipo> equipoUpdate = equipoInDB.map(oldEquipoInDB ->{
            Equipo teamAux= oldEquipoInDB.updateWith(team);
            return equipoRepository.save(teamAux);
        });
        return equipoUpdate;
    }

    @Override
    public void deleteTeam(long id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public Equipo findTeamByName(String name) {
        return equipoRepository.findByName(name);
    }

    
}
