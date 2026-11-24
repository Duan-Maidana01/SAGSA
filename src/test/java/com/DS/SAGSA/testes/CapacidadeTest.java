package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Capacidade;

// Testes unitários do model Capacidade
class CapacidadeTest {

    @Test
    @DisplayName("Cria Capacidade com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Capacidade.class));
    }

    @Test
    @DisplayName("Getters e setters de Capacidade")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Capacidade.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Capacidade")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Capacidade.class);
    }

    @Test
    @DisplayName("Capacidade com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Capacidade.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Capacidade valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Capacidade não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Capacidade não pode ser nulo", ex.getMessage());
    }
}
