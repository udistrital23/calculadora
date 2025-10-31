# language: es

Característica: Suma de dos valores ingresados

  Debo poder sumar dos números en bases diferentes [2 a 10] y mostrar el resultado en otra base numérica [2 a 10]. 

  Escenario: Suma exitosa en bases mixtas con resultado en base diferente
    Dado que el usuario quiere sumar dos números
    Cuando el número 1 es "1010" en base 2
    Y el número 2 es "10" en base 8
    Y la base de salida elegida es 10
    Entonces el resultado mostrado debe ser "18"

  Escenario: Suma simple con resultado en base 2
    Dado que el usuario quiere sumar dos números
    Cuando el número 1 es "7" en base 10
    Y el número 2 es "1" en base 10
    Y la base de salida elegida es 2
    Entonces el resultado mostrado debe ser "1000"

  Escenario: Rechazo por base de entrada fuera de rango
    Dado que el usuario quiere sumar dos números
    Cuando el número 1 es "12" en base 11
    Y el número 2 es "5" en base 10
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "La base debe estar en el rango de 2 a 10."

  Escenario: Rechazo por dígito no válido para la base
    Dado que el usuario quiere sumar dos números
    Cuando el número 1 es "21" en base 2
    Y el número 2 es "10" en base 2
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "El dígito '2' no es válido para la base 2"

  Escenario: Rechazo por base de salida fuera de rango
    Dado que el usuario quiere sumar dos números
    Cuando el número 1 es "10" en base 10
    Y el número 2 es "20" en base 10
    Y la base de salida elegida es 1
    Entonces se debe mostrar un mensaje de error "La base de salida 1 está fuera del rango [2-10]"
