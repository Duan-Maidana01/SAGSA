package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.Conhecimento;

@Repository
public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Long> {

    // Lista os registros de um(a) unidade curricular
    List<Conhecimento> findByUnidadeCurricular_IdOrderByIdAsc(Long unidadeCurricularId);
}
