package com.DS.SAGSA.testes;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

// Utilitário genérico: testa getters/setters, equals/hashCode e toString dos models
public final class ModelTestSupport {

    private ModelTestSupport() {}

    public static <T> T novaInstancia(Class<T> tipo) throws Exception {
        if (tipo == null) {
            throw new IllegalArgumentException("A classe do model não pode ser nula");
        }
        try {
            return tipo.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("O model " + tipo.getSimpleName() + " precisa de um construtor vazio");
        }
    }

    // Gera um valor de exemplo para o tipo do campo (null quando não sabe gerar)
    public static Object valorExemplo(Class<?> t, int seed) throws Exception {
        if (t == String.class) return "valor" + seed;
        if (t == Long.class || t == long.class) return (long) seed;
        if (t == Integer.class || t == int.class) return seed;
        if (t == Short.class || t == short.class) return (short) seed;
        if (t == Double.class || t == double.class) return seed + 0.5;
        if (t == Float.class || t == float.class) return seed + 0.5f;
        if (t == Boolean.class || t == boolean.class) return Boolean.TRUE;
        if (t == BigDecimal.class) return BigDecimal.valueOf(seed);
        if (t == LocalDate.class) return LocalDate.of(2026, 1, 1).plusDays(seed);
        if (t == LocalDateTime.class) return LocalDateTime.of(2026, 1, 1, 10, 0).plusDays(seed);
        if (t.isEnum()) return t.getEnumConstants().length > 0 ? t.getEnumConstants()[0] : null;
        if (t.getPackageName().equals(ModelTestSupport.class.getPackageName())) {
            try { return t.getDeclaredConstructor().newInstance(); } catch (NoSuchMethodException e) { return null; }
        }
        return null;
    }

    private static Method setter(Class<?> tipo, Field f) {
        try {
            return tipo.getMethod("set" + cap(f.getName()), f.getType());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("O campo " + f.getName() + " de " + tipo.getSimpleName() + " não tem setter");
        }
    }

    private static Method getter(Class<?> tipo, Field f) {
        try {
            return tipo.getMethod("get" + cap(f.getName()));
        } catch (NoSuchMethodException e) {
            try {
                return tipo.getMethod("is" + cap(f.getName()));
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("O campo " + f.getName() + " de " + tipo.getSimpleName() + " não tem getter");
            }
        }
    }

    private static String cap(String n) { return Character.toUpperCase(n.charAt(0)) + n.substring(1); }

    // Para cada campo: chama o setter e confere o getter
    public static void testarGettersESetters(Class<?> tipo) throws Exception {
        Object obj = novaInstancia(tipo);
        int seed = 1, testados = 0;
        for (Field f : tipo.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            Object v = valorExemplo(f.getType(), seed++);
            if (v == null) continue;
            Method set = setter(tipo, f);
            Method get = getter(tipo, f);
            set.invoke(obj, v);
            assertEquals(v, get.invoke(obj), "Campo " + f.getName() + " de " + tipo.getSimpleName());
            testados++;
        }
        assertTrue(testados > 0, "Nenhum campo testado em " + tipo.getSimpleName());
    }

    // Dois objetos preenchidos igualmente devem ser iguais e ter o mesmo hashCode
    public static void testarEqualsEHashCode(Class<?> tipo) throws Exception {
        Object a = preencher(tipo), b = preencher(tipo);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a, null);
        assertNotEquals(a, new Object());
        assertNotNull(a.toString());
    }

    private static Object preencher(Class<?> tipo) throws Exception {
        Object obj = novaInstancia(tipo);
        int seed = 1;
        for (Field f : tipo.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            Object v = valorExemplo(f.getType(), seed++);
            if (v == null) continue;
            setter(tipo, f).invoke(obj, v);
        }
        return obj;
    }

    // Entidades com campo "id": ids diferentes => objetos diferentes
    public static void testarIdDiferente(Class<?> tipo) throws Exception {
        Field id;
        try { id = tipo.getDeclaredField("id"); } catch (NoSuchFieldException e) { return; }
        if (id.getType() != Long.class) return;
        Object a = novaInstancia(tipo), b = novaInstancia(tipo);
        tipo.getMethod("setId", Long.class).invoke(a, 1L);
        tipo.getMethod("setId", Long.class).invoke(b, 2L);
        assertNotEquals(a, b);
    }
}
