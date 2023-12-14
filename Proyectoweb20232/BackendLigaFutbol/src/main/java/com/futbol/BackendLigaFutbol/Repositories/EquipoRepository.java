package com.futbol.BackendLigaFutbol.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.futbol.BackendLigaFutbol.Entities.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findAll ();
    
    Equipo findByName( String name);
    
}
