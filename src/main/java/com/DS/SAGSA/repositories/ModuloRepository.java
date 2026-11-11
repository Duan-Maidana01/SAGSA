package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long> {

    // Lista os registros de um(a) plano de curso
    List<Modulo> findByPlanoCurso_IdOrderByOrdemAsc(Long planoCursoId);
}
