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
    public void testDivisionValida() {
        // Preparación
        Numero num1 = new Numero("110", 2); // 6 en decimal
        Numero num2 = new Numero("11", 2);  // 3 en decimal
        Division division = new Division();
        
        // Ejecución
        double resultadoDecimal = division.calcular(num1, num2);
        
        // Verificación
        assertEquals(2.0, resultadoDecimal, "La división debería dar 2.0.");
    }
    
    @Test
    public void testDivisionPorCero() {
        // Preparación
        Numero num1 = new Numero("110", 2); // 6 en decimal
        Numero num2 = new Numero("0", 2);   // 0 en decimal
        Division division = new Division();
        
        // Ejecución y verificación de la excepción
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            division.calcular(num1, num2);
        });
        
        assertEquals("No se puede dividir por cero.", thrown.getMessage());
    }


}