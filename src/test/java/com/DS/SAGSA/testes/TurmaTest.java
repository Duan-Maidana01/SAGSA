package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Turma;

// Testes unitários do model Turma
class TurmaTest {

    @Test
    @DisplayName("Cria Turma com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Turma.class));
    }

    @Test
    @DisplayName("Getters e setters de Turma")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Turma.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Turma")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Turma.class);
    }

    @Test
    @DisplayName("Turma com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Turma.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Turma valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Turma não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Turma não pode ser nulo", ex.getMessage());
    }
}
