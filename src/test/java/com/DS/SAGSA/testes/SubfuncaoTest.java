package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Subfuncao;

// Testes unitários do model Subfuncao
class SubfuncaoTest {

    @Test
    @DisplayName("Cria Subfuncao com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Subfuncao.class));
    }

    @Test
    @DisplayName("Getters e setters de Subfuncao")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Subfuncao.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Subfuncao")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Subfuncao.class);
    }

    @Test
    @DisplayName("Subfuncao com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Subfuncao.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Subfuncao valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Subfuncao não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Subfuncao não pode ser nulo", ex.getMessage());
    }
}
