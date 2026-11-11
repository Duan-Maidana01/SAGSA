package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.Funcao;

@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Long> {

    // Lista os registros de um(a) plano de curso
    List<Funcao> findByPlanoCurso_IdOrderByNumeroAsc(Long planoCursoId);
}
