package com.futbol.BackendLigaFutbol.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.futbol.BackendLigaFutbol.Entities.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    

}
