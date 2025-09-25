package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    @Test
    public void testConvertirADecimal() {
        // 101 en base 2 = 5 en decimal
        Numero num = new Numero("101", 2);
        assertEquals(5, num.convertirADecimal());
    }

    @Test
    public void testConvertirDeDecimal() {
        // 15 en decimal convertido a base 8 debe ser "17"
        String valorEnBase8 = Numero.convertirDeDecimal(15, 8);
        assertEquals("17", valorEnBase8);
    }

    @Test
    public void testRestaDecimal() {
        Numero num1 = new Numero("10", 10); // 10 en base 10
        Numero num2 = new Numero("3", 10); // 3 en base 10
        Resta resta = new Resta();

        double resultado = resta.calcular(num1, num2);

        assertEquals(7, resultado, "10 - 3 debe ser 7 en base decimal");
    }

    @Test
    public void testRestaBinario() {
        Numero num1 = new Numero("1010", 2); // 1010 en base 2 = 10 en decimal
        Numero num2 = new Numero("11", 2); // 11 en base 2 = 3 en decimal
        Resta resta = new Resta();

        double resultado = resta.calcular(num1, num2);

        assertEquals(7, resultado, "1010 (binario) - 11 (binario) debe ser 7 en decimal");
    }

}