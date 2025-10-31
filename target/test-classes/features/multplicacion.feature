# language: es

Característica: Multiplicación de dos valores ingresados

  Debo poder multiplicar dos números en bases diferentes [2 a 10] y mostrar el resultado en otra base numérica [2 a 10].

  Escenario: Multiplicación Exitosa en Bases Mixtas
    Dado que el usuario quiere multiplicar dos números
    Cuando el factor 1 es "10" en base 2
    Y el factor 2 es "3" en base 4
    Y la base de salida elegida es 10
    Entonces el resultado mostrado debe ser "6"

  Escenario: Multiplicación Simple en Base 5
    Dado que el usuario quiere multiplicar dos números
    Cuando el factor 1 es "4" en base 5
    Y el factor 2 es "3" en base 5
    Y la base de salida elegida es 5
    Entonces el resultado mostrado debe ser "22"

  Escenario: Rechazo por Base de Factor 2 Fuera de Rango
    Dado que el usuario quiere multiplicar dos números
    Cuando el factor 1 es "100" en base 10
    Y el factor 2 es "50" en base 1
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "La base debe estar en el rango de 2 a 10."

  Escenario: Rechazo por Dígito No Válido para la Base
    Dado que el usuario quiere multiplicar dos números
    Cuando el factor 1 es "63" en base 5
    Y el factor 2 es "10" en base 2
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "El dígito '6' no es válido para la base 5"

  Escenario: Rechazo por Base de Salida Fuera de Rango
    Dado que el usuario quiere multiplicar dos números
    Cuando el factor 1 es "19" en base 10
    Y el factor 2 es "20" en base 7
    Y la base de salida elegida es 12
    Entonces se debe mostrar un mensaje de error "La base de salida 12 está fuera del rango [2-10]"
