package com.DS.SAGSA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DS.SAGSA.models.SapzCompartilhamento;

@Repository
public interface SapzCompartilhamentoRepository extends JpaRepository<SapzCompartilhamento, Long> {

    List<SapzCompartilhamento> findBySituacaoAprendizagem_IdOrderByDataCompartilhamentoDesc(Long situacaoAprendizagemId);

    long countBySituacaoAprendizagem_Id(Long situacaoAprendizagemId);
}
