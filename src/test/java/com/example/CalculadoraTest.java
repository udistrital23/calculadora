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

}