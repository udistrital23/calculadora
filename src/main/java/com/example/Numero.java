package com.example;

public class Numero {
    private String valor;
    private int base;

    public Numero(String valor, int base) {
        validarBase(base);
        validarValorEnBase(valor, base);
        this.valor = valor;
        this.base = base;
    }

    private void validarBase(int base) {
        if (base < 2 || base > 10) {
            throw new IllegalArgumentException("La base debe estar en el rango de 2 a 10.");
        }
    }

    private void validarValorEnBase(String valor, int base) {
        for (char digito : valor.toCharArray()) {
            int valorDigito;
            if (Character.isDigit(digito)) {
                valorDigito = Character.getNumericValue(digito);
            } else {
                throw new IllegalArgumentException("El carácter '" + digito + "' no es un dígito válido.");
            }

            if (valorDigito >= base) {
                throw new IllegalArgumentException("El dígito '" + digito + "' no es válido para la base " + base + "");
            }
        }
    }

    public String mostrarValor() {
        return valor;
    }

    public int mostrarBase() {
        return base;
    }

    public int convertirADecimal() {
        return Integer.parseInt(valor, base);
    }

    public static String convertirDeDecimal(int valorDecimal, int base) {
        return Integer.toString(valorDecimal, base);
    }
}
