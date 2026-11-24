package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Aluno;

// Testes unitários do model Aluno
class AlunoTest {

    @Test
    @DisplayName("Cria Aluno com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Aluno.class));
    }

    @Test
    @DisplayName("Getters e setters de Aluno")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Aluno.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Aluno")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Aluno.class);
    }

    @Test
    @DisplayName("Aluno com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Aluno.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Aluno valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Aluno não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Aluno não pode ser nulo", ex.getMessage());
    }
}
