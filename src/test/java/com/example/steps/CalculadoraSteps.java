package com.example.steps;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Numero;
import com.example.Suma;
import com.example.Resta;
import com.example.Division;
import com.example.Multiplicacion;

import io.cucumber.java.es.*;

public class CalculadoraSteps {

    // Variables generales
    private Numero num1;
    private Numero num2;
    private Numero minuendo;
    private Numero sustraendo;
    private int baseSalida;
    private String resultado;
    private Exception error;
    private Numero dividendo;
    private Numero divisor;
    private Numero factor1;
    private Numero factor2;

    // ===================== SUMA =====================
    @Dado("que el usuario quiere sumar dos números")
    public void usuario_quiere_sumar() {
        num1 = null;
        num2 = null;
        baseSalida = 10;
        resultado = null;
        error = null;
    }

    @Cuando("el número 1 es {string} en base {int}")
    public void numero1_es_en_base(String valor, int base) {
        try {
            num1 = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    @Cuando("el número 2 es {string} en base {int}")
    public void numero2_es_en_base(String valor, int base) {
        try {
            num2 = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    // ===================== RESTA =====================
    @Dado("que el usuario quiere restar dos números")
    public void usuario_quiere_restar() {
        minuendo = null;
        sustraendo = null;
        baseSalida = 10;
        resultado = null;
        error = null;
    }

    @Cuando("el minuendo es {string} en base {int}")
    public void el_minuendo_es_en_base(String valor, int base) {
        try {
            minuendo = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    @Cuando("el sustraendo es {string} en base {int}")
    public void el_sustraendo_es_en_base(String valor, int base) {
        try {
            sustraendo = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    // ===================== RESULTADOS =====================
    @Entonces("el resultado mostrado debe ser {string}")
    public void el_resultado_mostrado_debe_ser(String esperado) {
        assertNull(error, () -> "Se esperaba un resultado válido pero ocurrió un error: " +
                (error != null ? error.getMessage() : "null"));
        assertEquals(esperado, resultado);
    }

    @Entonces("se debe mostrar un mensaje de error {string}")
    public void se_debe_mostrar_un_mensaje_de_error(String mensajeEsperado) {
        assertNotNull(error, "Se esperaba un error pero no ocurrió ninguno");
        assertEquals(mensajeEsperado, error.getMessage());
    }

    // ===================== DIVISIÓN =====================
    @Dado("que el usuario quiere dividir dos números")
    public void usuario_quiere_dividir() {
        dividendo = null;
        divisor = null;
        baseSalida = 10;
        resultado = null;
        error = null;
    }

    @Cuando("el dividendo es {string} en base {int}")
    public void el_dividendo_es_en_base(String valor, int base) {
        try {
            dividendo = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    @Cuando("el divisor es {string} en base {int}")
    public void el_divisor_es_en_base(String valor, int base) {
        try {
            divisor = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    // ===================== MULTIPLICACIÓN =====================
    @Dado("que el usuario quiere multiplicar dos números")
    public void usuario_quiere_multiplicar() {
        factor1 = null;
        factor2 = null;
        baseSalida = 10;
        resultado = null;
        error = null;
    }

    @Cuando("el factor 1 es {string} en base {int}")
    public void el_factor1_es_en_base(String valor, int base) {
        try {
            factor1 = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    @Cuando("el factor 2 es {string} en base {int}")
    public void el_factor2_es_en_base(String valor, int base) {
        try {
            factor2 = new Numero(valor, base);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    // Modificar el método la_base_de_salida_es para incluir multiplicación
    @Cuando("la base de salida elegida es {int}")
    public void la_base_de_salida_es(int base) {
        this.baseSalida = base;
        if (error != null)
            return;

        try {
            if (baseSalida < 2 || baseSalida > 10) {
                throw new IllegalArgumentException("La base de salida " + baseSalida + " está fuera del rango [2-10]");
            }

            if (num1 != null && num2 != null) {
                // Suma
                Suma suma = new Suma();
                double resultadoDecimal = suma.calcular(num1, num2);
                resultado = Numero.convertirDeDecimal((int) resultadoDecimal, baseSalida);
            } else if (minuendo != null && sustraendo != null) {
                // Resta
                Resta resta = new Resta();
                double resultadoDecimal = resta.calcular(minuendo, sustraendo);
                resultado = Numero.convertirDeDecimal((int) resultadoDecimal, baseSalida);
            } else if (dividendo != null && divisor != null) {
                // División
                Division division = new Division();
                if (divisor.convertirADecimal() == 0) {
                    throw new IllegalArgumentException("No es posible dividir por cero");
                }
                double resultadoDecimal = division.calcular(dividendo, divisor);
                resultado = Numero.convertirDeDecimal((int) resultadoDecimal, baseSalida);
            } else if (factor1 != null && factor2 != null) {
                // Multiplicación
                Multiplicacion multiplicacion = new Multiplicacion();
                double resultadoDecimal = multiplicacion.calcular(factor1, factor2);
                resultado = Numero.convertirDeDecimal((int) resultadoDecimal, baseSalida);
            }
        } catch (Exception e) {
            error = e;
        }
    }

}
