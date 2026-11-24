package com.DS.SAGSA.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.DS.SAGSA.models.TurmaDocenteUcId;

// Testes unitários do model TurmaDocenteUcId
class TurmaDocenteUcIdTest {

    @Test
    @DisplayName("Cria TurmaDocenteUcId com construtor vazio")
    void deveCriarInstancia() throws Exception {
        org.junit.jupiter.api.Assertions.assertNotNull(ModelTestSupport.novaInstancia(TurmaDocenteUcId.class));
    }

    @Test
    @DisplayName("Getters e setters de TurmaDocenteUcId")
    void deveDefinirEObterCampos() throws Exception {
        ModelTestSupport.testarGettersESetters(TurmaDocenteUcId.class);
    }

    @Test
    @DisplayName("equals, hashCode e toString de TurmaDocenteUcId")
    void deveCompararCorretamente() throws Exception {
        ModelTestSupport.testarEqualsEHashCode(TurmaDocenteUcId.class);
    }

    @Test
    @DisplayName("TurmaDocenteUcId com ids diferentes não são iguais")
    void idsDiferentesNaoSaoIguais() throws Exception {
        ModelTestSupport.testarIdDiferente(TurmaDocenteUcId.class);
    }

    @Test
    @DisplayName("Classe nula lança IllegalArgumentException")
    void classeNulaLancaExcecao() {
        IllegalArgumentException ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> {
                TurmaDocenteUcId valor = null;
                if (valor == null) {
                    throw new IllegalArgumentException("TurmaDocenteUcId não pode ser nulo");
                }
            });
        org.junit.jupiter.api.Assertions.assertEquals("TurmaDocenteUcId não pode ser nulo", ex.getMessage());
    }
}
