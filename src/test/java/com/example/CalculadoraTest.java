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
    void testSumaDecimal() {
        Numero num1 = new Numero("10", 10); // 10 en base 10
        Numero num2 = new Numero("5", 10);  // 5 en base 10
        Suma suma = new Suma();

        double resultado = suma.calcular(num1, num2);

        assertEquals(15, resultado, "10 + 5 en base 10 debería ser 15");
    }

    @Test
    void testSumaBinaria() {
        Numero num1 = new Numero("101", 2); // 5 en decimal
        Numero num2 = new Numero("11", 2);  // 3 en decimal
        Suma suma = new Suma();

        double resultado = suma.calcular(num1, num2);

        assertEquals(8, resultado, "101(base2=5) + 11(base2=3) debería ser 8 en decimal");
    }
    @Test
    void testMultiplicacionBaseDecimal() {
        Numero num1 = new Numero("5", 10); // 5 en base 10
        Numero num2 = new Numero("3", 10); // 3 en base 10

        Operacion operacion = new Multiplicacion();
        double resultado = operacion.calcular(num1, num2);

        assertEquals(15.0, resultado);
    }

    @Test
    void testMultiplicacionBaseBinaria() {
        Numero num1 = new Numero("101", 2); // 5 en base 2
        Numero num2 = new Numero("11", 2);  // 3 en base 2

        Operacion operacion = new Multiplicacion();
        double resultado = operacion.calcular(num1, num2);

        assertEquals(15.0, resultado);
    }
}