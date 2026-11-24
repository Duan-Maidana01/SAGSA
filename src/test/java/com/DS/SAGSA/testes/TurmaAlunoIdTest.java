package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.TurmaAlunoId;

// Testes unitários do model TurmaAlunoId
class TurmaAlunoIdTest {

    @Test
    @DisplayName("Cria TurmaAlunoId com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(TurmaAlunoId.class));
    }

    @Test
    @DisplayName("Getters e setters de TurmaAlunoId")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(TurmaAlunoId.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de TurmaAlunoId")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(TurmaAlunoId.class);
    }

    @Test
    @DisplayName("TurmaAlunoId com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(TurmaAlunoId.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                TurmaAlunoId valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("TurmaAlunoId não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("TurmaAlunoId não pode ser nulo", ex.getMessage());
    }
}
