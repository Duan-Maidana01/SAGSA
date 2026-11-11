package com.DS.SAGSA.models.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.DS.SAGSA.models.TurmaAluno;
import com.DS.SAGSA.models.enums.StatusMatriculaEnum;

// Saída (GET) de matrícula
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TurmaAlunoResponseDTO {

    private Long turmaId;
    private String turmaCodigo;
    private Long alunoId;
    private String alunoNome;
    private String alunoMatricula;
    private LocalDate dataMatricula;
    private StatusMatriculaEnum status;

    public static TurmaAlunoResponseDTO fromEntity(TurmaAluno obj) {
        return new TurmaAlunoResponseDTO(
                obj.getTurma().getId(),
                obj.getTurma().getCodigoTurma(),
                obj.getAluno().getId(),
                obj.getAluno().getNome(),
                obj.getAluno().getMatricula(),
                obj.getDataMatricula(),
                obj.getStatus());
    }
}
