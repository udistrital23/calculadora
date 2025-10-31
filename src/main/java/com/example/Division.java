package com.example;

public class Division extends Operacion {
    @Override
    public double calcular(Numero num1, Numero num2) {
        if (num2.convertirADecimal() == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return (double) num1.convertirADecimal() / num2.convertirADecimal();
    }
}
