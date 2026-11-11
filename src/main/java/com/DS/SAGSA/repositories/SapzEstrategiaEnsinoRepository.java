package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.SapzEstrategiaEnsino;

@Repository
public interface SapzEstrategiaEnsinoRepository extends JpaRepository<SapzEstrategiaEnsino, Long> {

    // Lista os registros de um(a) situação de aprendizagem
    List<SapzEstrategiaEnsino> findBySituacaoAprendizagem_IdOrderByIdAsc(Long situacaoAprendizagemId);
}
