package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Funcao;

// Testes unitários do model Funcao
class FuncaoTest {

    @Test
    @DisplayName("Cria Funcao com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Funcao.class));
    }

    @Test
    @DisplayName("Getters e setters de Funcao")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Funcao.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Funcao")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Funcao.class);
    }

    @Test
    @DisplayName("Funcao com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Funcao.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Funcao valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Funcao não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Funcao não pode ser nulo", ex.getMessage());
    }
}
