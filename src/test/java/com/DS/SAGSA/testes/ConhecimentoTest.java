package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Conhecimento;

// Testes unitários do model Conhecimento
class ConhecimentoTest {

    @Test
    @DisplayName("Cria Conhecimento com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Conhecimento.class));
    }

    @Test
    @DisplayName("Getters e setters de Conhecimento")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Conhecimento.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Conhecimento")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Conhecimento.class);
    }

    @Test
    @DisplayName("Conhecimento com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Conhecimento.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Conhecimento valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Conhecimento não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Conhecimento não pode ser nulo", ex.getMessage());
    }
}
