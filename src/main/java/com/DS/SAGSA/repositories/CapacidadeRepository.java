package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.Capacidade;
import com.DS.SAGSA.models.enums.TipoCapacidadeEnum;

@Repository
public interface CapacidadeRepository extends JpaRepository<Capacidade, Long> {

    // Lista as capacidades de uma unidade curricular
    List<Capacidade> findByUnidadeCurricular_IdOrderByIdAsc(Long unidadeCurricularId);

    // Lista as capacidades de uma UC filtrando pelo tipo (BASICA, TECNICA, SOCIOEMOCIONAL)
    List<Capacidade> findByUnidadeCurricular_IdAndTipoOrderByIdAsc(Long unidadeCurricularId, TipoCapacidadeEnum tipo);
}
