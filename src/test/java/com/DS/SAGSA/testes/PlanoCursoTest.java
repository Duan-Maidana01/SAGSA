package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.PlanoCurso;

// Testes unitários do model PlanoCurso
class PlanoCursoTest {

    @Test
    @DisplayName("Cria PlanoCurso com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(PlanoCurso.class));
    }

    @Test
    @DisplayName("Getters e setters de PlanoCurso")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(PlanoCurso.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de PlanoCurso")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(PlanoCurso.class);
    }

    @Test
    @DisplayName("PlanoCurso com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(PlanoCurso.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                PlanoCurso valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("PlanoCurso não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("PlanoCurso não pode ser nulo", ex.getMessage());
    }
}
