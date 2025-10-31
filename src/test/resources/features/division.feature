# language: es

Característica: División de dos valores ingresados

  Debo poder dividir dos números en bases diferentes [2 a 10] y mostrar el resultado en otra base numérica [2 a 10].

  Escenario: División Exitosa en Bases Mixtas
    Dado que el usuario quiere dividir dos números
    Cuando el dividendo es "32" en base 4
    Y el divisor es "7" en base 10
    Y la base de salida elegida es 2
    Entonces el resultado mostrado debe ser "1"

  Escenario: Rechazo por División por Cero
    Dado que el usuario quiere dividir dos números
    Cuando el dividendo es "100" en base 10
    Y el divisor es "0" en base 10
    Y la base de salida elegida es 8
    Entonces se debe mostrar un mensaje de error "No es posible dividir por cero"

  Escenario: Rechazo por Base de Divisor Fuera de Rango
    Dado que el usuario quiere dividir dos números
    Cuando el dividendo es "52" en base 10
    Y el divisor es "19" en base 12
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "La base debe estar en el rango de 2 a 10."

  Escenario: Rechazo por Dígito No Válido para la Base
    Dado que el usuario quiere dividir dos números
    Cuando el dividendo es "60" en base 5
    Y el divisor es "10" en base 2
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "El dígito '6' no es válido para la base 5"

  Escenario: Rechazo por Base de Salida Fuera de Rango
    Dado que el usuario quiere dividir dos números
    Cuando el dividendo es "18" en base 10
    Y el divisor es "12" en base 7
    Y la base de salida elegida es 12
    Entonces se debe mostrar un mensaje de error "La base de salida 12 está fuera del rango [2-10]"
