package com.futbol.BackendLigaFutbol.Controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.futbol.BackendLigaFutbol.Dtos.EquipoDtos.EquipoCreateDto;
import com.futbol.BackendLigaFutbol.Dtos.EquipoDtos.EquipoDto;
import com.futbol.BackendLigaFutbol.Dtos.EquipoDtos.EquipoMapper;
import com.futbol.BackendLigaFutbol.Entities.Equipo;

import com.futbol.BackendLigaFutbol.Services.EquipoService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipoController {

    private EquipoService teamService;
    private EquipoMapper teamMapper;

    public EquipoController(EquipoService servicio, EquipoMapper mapper){
        this.teamService=servicio;
        this.teamMapper=mapper;
    }

    @GetMapping("/allTeams")
    public ResponseEntity<List<EquipoCreateDto>> findAll(){
        List<Equipo> equipos = teamService.findAllTeams();
        List<EquipoCreateDto> trueTeams=equipos.stream().map(t-> teamMapper.toEquipoCreate(t)).collect(Collectors.toList());
        return ResponseEntity.ok().body(trueTeams);
    }

    @GetMapping("/team")
    public ResponseEntity<EquipoCreateDto> findByName(@RequestParam("name") String name) {
        Equipo team = teamService.findTeamByName(name);
        EquipoCreateDto trueTeam = teamMapper.toEquipoCreate(team);
        return ResponseEntity.ok().body(trueTeam);
    }

    @PostMapping("/team")
    public ResponseEntity<EquipoCreateDto> create(@RequestBody @Validated EquipoDto teamDto){
        Equipo newTeam = teamMapper.toEntity(teamDto);
        Equipo teamCreated= null;

        teamCreated= teamService.createTeam(newTeam);

        EquipoCreateDto trueTeam = teamMapper.toEquipoCreate(teamCreated);
        URI locacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(trueTeam.getId()).toUri();

        return ResponseEntity.created(locacion).body(trueTeam);

    }

    @PutMapping("/team/{id}")
    public ResponseEntity<EquipoCreateDto> update(@PathVariable long id, @RequestBody @Validated EquipoCreateDto teamDtoCreated){
        Equipo teamUpdate = teamMapper.toEquipoByDtoCreated(teamDtoCreated);
        return teamService.updateTeam(id, teamUpdate).map(teamActualizado -> ResponseEntity.ok().body(teamMapper.toEquipoCreate(teamUpdate))).orElseGet(()->{
            Equipo teamCreado = teamService.createTeam(teamUpdate);

            EquipoCreateDto trueTeam = teamMapper.toEquipoCreate(teamUpdate);
            URI locacion = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(trueTeam.getId()).toUri();
                return ResponseEntity.created(locacion).body(trueTeam);
        });

    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<EquipoCreateDto> delete (@PathVariable("id") int id ){
        teamService.deleteTeam(id);
        return ResponseEntity.ok().build();
    }
    
}
