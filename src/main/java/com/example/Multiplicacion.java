package com.example;

public class Multiplicacion extends Operacion {
    @Override
    public double calcular(Numero num1, Numero num2) {
        return num1.convertirADecimal() * num2.convertirADecimal();
    }
}
