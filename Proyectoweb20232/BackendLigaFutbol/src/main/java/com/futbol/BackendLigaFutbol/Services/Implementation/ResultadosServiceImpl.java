package com.futbol.BackendLigaFutbol.Services.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.futbol.BackendLigaFutbol.Entities.Resultado;

import com.futbol.BackendLigaFutbol.Repositories.ResultadoRepository;
import com.futbol.BackendLigaFutbol.Services.ResultadoService;

@Service
public class ResultadosServiceImpl implements ResultadoService {

    private final ResultadoRepository resultadoRepo;
    

    public ResultadosServiceImpl(ResultadoRepository resultadoRepo){
        this.resultadoRepo=resultadoRepo;
    }
    @Override
    public Resultado createResultado(Resultado resultado) {
        Resultado scoreCopy = new Resultado();
        scoreCopy.setGolLocal(resultado.getGolLocal());
        scoreCopy.setGolVisitante(resultado.getGolVisitante());
        scoreCopy.setNRojas(resultado.getNRojas());
        scoreCopy.setNAmarillas(resultado.getNAmarillas());
        scoreCopy.setEquipoLocal(resultado.getEquipoLocal());
        scoreCopy.setEquipoVisitante(resultado.getEquipoVisitante());

        return resultadoRepo.save(scoreCopy);
    }

    @Override
    public Optional<Resultado> findResultadoById(long id) {
        return resultadoRepo.findById(id);
    }

    @Override
    public Optional<Resultado> updateResultado(long id, Resultado resultado) {
        Optional<Resultado> scoreInDB = resultadoRepo.findById(id);

        Optional<Resultado> scoreUpdated = scoreInDB.map(oldScoreInDB ->{
            Resultado scoreAux = oldScoreInDB.updateWith(resultado);
            return resultadoRepo.save(scoreAux);
        });
        return scoreUpdated;
        
    }

    @Override
    public List<Resultado> findAllScores(){
        return resultadoRepo.findAll();
    }
   
    
}
