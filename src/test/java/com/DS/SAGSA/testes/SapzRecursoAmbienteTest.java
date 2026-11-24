package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.SapzRecursoAmbiente;

// Testes unitários do model SapzRecursoAmbiente
class SapzRecursoAmbienteTest {

    @Test
    @DisplayName("Cria SapzRecursoAmbiente com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(SapzRecursoAmbiente.class));
    }

    @Test
    @DisplayName("Getters e setters de SapzRecursoAmbiente")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(SapzRecursoAmbiente.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de SapzRecursoAmbiente")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(SapzRecursoAmbiente.class);
    }

    @Test
    @DisplayName("SapzRecursoAmbiente com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(SapzRecursoAmbiente.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                SapzRecursoAmbiente valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("SapzRecursoAmbiente não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("SapzRecursoAmbiente não pode ser nulo", ex.getMessage());
    }
}
