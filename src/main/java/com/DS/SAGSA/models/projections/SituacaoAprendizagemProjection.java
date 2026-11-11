package com.DS.SAGSA.models.projections;

import java.time.LocalDateTime;

import com.DS.SAGSA.models.enums.TipoEstrategiaEnum;

// Projeção resumida de SA (listagem "minhas situações de aprendizagem")
public interface SituacaoAprendizagemProjection {

    Long getId();

    String getTitulo();

    TipoEstrategiaEnum getTipoEstrategia();

    Integer getCargaHorariaSa();

    Boolean getCompartilhada();

    LocalDateTime getDataAtualizacao();
}
