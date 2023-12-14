package com.futbol.BackendLigaFutbol.Controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.futbol.BackendLigaFutbol.Dtos.ResultadoDtos.ResultadoDto;
import com.futbol.BackendLigaFutbol.Dtos.ResultadoDtos.ResultadoDtoCreate;
import com.futbol.BackendLigaFutbol.Dtos.ResultadoDtos.ResultadoMapper;
import com.futbol.BackendLigaFutbol.Entities.Resultado;
import com.futbol.BackendLigaFutbol.Services.ResultadoService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResultadoController {

    private final ResultadoService scoreService;
    private final ResultadoMapper scoreMapper;
    

    public ResultadoController(ResultadoService servicio, ResultadoMapper mapeador){
        this.scoreService=servicio;
        this.scoreMapper=mapeador;
        
    }

    @PostMapping("/score")
    public ResponseEntity<ResultadoDtoCreate> create(@RequestBody ResultadoDto scoreDto){
        
            Resultado newScore = scoreMapper.toEntity(scoreDto);
            Resultado scoreCreated=null;

        scoreCreated=scoreService.createResultado(newScore);
        ResultadoDtoCreate trueScore = scoreMapper.toResultCreated(scoreCreated);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(trueScore.getId()).toUri();
        return ResponseEntity.created(locacion).body(trueScore);
       
        
    }

    @PutMapping("/score/{id}")
    public ResponseEntity<ResultadoDtoCreate> upDate(@PathVariable long id, @RequestBody ResultadoDtoCreate score){
        
            Resultado resultadoUpdate = scoreMapper.toResultadoByDtoCreated(score);
        return scoreService.updateResultado(id, resultadoUpdate).map(scoreActualizado-> ResponseEntity.ok().body(scoreMapper.toResultCreated(resultadoUpdate))).orElseGet(()->{
            Resultado scoreCreado = scoreService.createResultado(resultadoUpdate);
            ResultadoDtoCreate trueScore = scoreMapper.toResultCreated(resultadoUpdate);

            URI locacion = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(trueScore.getId()).toUri();
                return ResponseEntity.created(locacion).body(trueScore);
        });
    }

    @GetMapping("/allScore")
    public ResponseEntity<List<ResultadoDtoCreate>> findAll(){
            List<Resultado> resultados = scoreService.findAllScores();
            List<ResultadoDtoCreate> verdaderosResultados = resultados.stream().map(r->scoreMapper.toResultCreated(r)).collect(Collectors.toList());
            return ResponseEntity.ok().body(verdaderosResultados);
        }

   


   
    
}
