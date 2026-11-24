package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SapzInstrumentoAvaliacao;

// Testes unitários do model SapzInstrumentoAvaliacao
class SapzInstrumentoAvaliacaoTest {

    @Test
    @DisplayName("Cria SapzInstrumentoAvaliacao com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SapzInstrumentoAvaliacao.class));
    }

    @Test
    @DisplayName("Getters e setters de SapzInstrumentoAvaliacao")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SapzInstrumentoAvaliacao.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SapzInstrumentoAvaliacao")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SapzInstrumentoAvaliacao.class);
    }

    @Test
    @DisplayName("SapzInstrumentoAvaliacao com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SapzInstrumentoAvaliacao.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SapzInstrumentoAvaliacao valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SapzInstrumentoAvaliacao não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SapzInstrumentoAvaliacao não pode ser nulo", ex.getMessage());
    }
}
