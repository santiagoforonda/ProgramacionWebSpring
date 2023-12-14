package com.futbol.BackendLigaFutbol.Controllers;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.futbol.BackendLigaFutbol.Dtos.PartidoDtos.PartidoDto;
import com.futbol.BackendLigaFutbol.Dtos.PartidoDtos.PartidoDtoCreate;
import com.futbol.BackendLigaFutbol.Dtos.PartidoDtos.PartidoMapper;
import com.futbol.BackendLigaFutbol.Entities.Partido;
import com.futbol.BackendLigaFutbol.Services.PartidosService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartidoController {

    private final PartidosService matchService;
    private final PartidoMapper matchMapper;

    public PartidoController(PartidosService servicio, PartidoMapper mapeador){
        this.matchService=servicio;
        this.matchMapper=mapeador;
    }

    @GetMapping("/allMatchs")
    public ResponseEntity<List<PartidoDtoCreate>> findAll(){
        List<Partido> partidos = matchService.findall();
        List<PartidoDtoCreate> verdaderosParrtidos = partidos.stream().map(p->matchMapper.toPartidoCreate(p)).collect(Collectors.toList());
        return ResponseEntity.ok().body(verdaderosParrtidos);

    }
    
    @GetMapping("/listmatchesByDate")
    public ResponseEntity<List<PartidoDtoCreate>> findByDate(@RequestParam("fecha")  @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha){
        List<Partido> partidos = matchService.findPartidosByFecha(fecha);
        List<PartidoDtoCreate> trueMatches = partidos.stream().map(m-> matchMapper.toPartidoCreate(m)).collect(Collectors.toList());
        return ResponseEntity.ok().body(trueMatches);
    }


    @GetMapping("/listmatchesByTeam")
    public ResponseEntity<List<PartidoDtoCreate>> findByTeam(@RequestParam("name") String name){
        List<Partido> partidos = matchService.findPartidosByTeam(name);
        List<PartidoDtoCreate> trueMatches = partidos.stream().map(m->matchMapper.toPartidoCreate(m)).collect(Collectors.toList());
        return ResponseEntity.ok().body(trueMatches);
    }

    @PostMapping("/match")
    public ResponseEntity<PartidoDtoCreate> create(@RequestBody @Validated PartidoDto matchDto){
        Partido newMatch = matchMapper.toEntity(matchDto);
        Partido matchCreated = null;
        matchCreated= matchService.createPartido(newMatch);
        PartidoDtoCreate trueMatch = matchMapper.toPartidoCreate(matchCreated);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(trueMatch.getId()).toUri();
        return ResponseEntity.created(locacion).body(trueMatch);
    }
    


    @PatchMapping("/match/{id}")
    public ResponseEntity<PartidoDtoCreate> upDate(@PathVariable long id, @RequestBody  PartidoDtoCreate partido){
        Partido partidoUpdate = matchMapper.toPartidoByDtoCreated(partido);
        return matchService.updatePartido(id, partidoUpdate).map(matchActualizado-> ResponseEntity.ok().body(matchMapper.toPartidoCreate(partidoUpdate))).orElseGet(()->{
            Partido matchCreado = matchService.createPartido(partidoUpdate);
            PartidoDtoCreate trueMatch = matchMapper.toPartidoCreate(partidoUpdate);

            URI locacion = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(trueMatch.getId()).toUri();
                return ResponseEntity.created(locacion).body(trueMatch);
        });
}
}