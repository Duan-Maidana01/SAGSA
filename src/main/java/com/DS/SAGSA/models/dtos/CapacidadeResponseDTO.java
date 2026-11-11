package com.DS.SAGSA.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.DS.SAGSA.models.Capacidade;
import com.DS.SAGSA.models.enums.DominioCapacidadeEnum;
import com.DS.SAGSA.models.enums.TipoCapacidadeEnum;

// Saída (GET) de capacidades
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CapacidadeResponseDTO {

    private Long id;
    private Long unidadeCurricularId;
    private String unidadeCurricularNome;
    private TipoCapacidadeEnum tipo;
    private DominioCapacidadeEnum dominio;
    private String descricao;
    private List<Long> padraoDesempenhoIds;

    public static CapacidadeResponseDTO fromEntity(Capacidade obj) {
        return new CapacidadeResponseDTO(
                obj.getId(),
                obj.getUnidadeCurricular().getId(),
                obj.getUnidadeCurricular().getNome(),
                obj.getTipo(),
                obj.getDominio(),
                obj.getDescricao(),
                obj.getPadroesDesempenho().stream().map(p -> p.getId()).sorted().toList());
    }
}
