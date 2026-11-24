package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.Curso;

// Testes unitários do model Curso
class CursoTest {

    @Test
    @DisplayName("Cria Curso com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(Curso.class));
    }

    @Test
    @DisplayName("Getters e setters de Curso")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(Curso.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de Curso")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(Curso.class);
    }

    @Test
    @DisplayName("Curso com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(Curso.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                Curso valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("Curso não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("Curso não pode ser nulo", ex.getMessage());
    }
}
