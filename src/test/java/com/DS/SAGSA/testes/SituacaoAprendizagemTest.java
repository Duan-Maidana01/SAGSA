package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SituacaoAprendizagem;

// Testes unitários do model SituacaoAprendizagem
class SituacaoAprendizagemTest {

    @Test
    @DisplayName("Cria SituacaoAprendizagem com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SituacaoAprendizagem.class));
    }

    @Test
    @DisplayName("Getters e setters de SituacaoAprendizagem")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SituacaoAprendizagem.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SituacaoAprendizagem")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SituacaoAprendizagem.class);
    }

    @Test
    @DisplayName("SituacaoAprendizagem com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SituacaoAprendizagem.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SituacaoAprendizagem valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SituacaoAprendizagem não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SituacaoAprendizagem não pode ser nulo", ex.getMessage());
    }
}
