package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.UnidadeCurricular;

@Repository
public interface UnidadeCurricularRepository extends JpaRepository<UnidadeCurricular, Long> {

    // Lista os registros de um(a) módulo
    List<UnidadeCurricular> findByModulo_IdOrderByOrdemAsc(Long moduloId);
}
