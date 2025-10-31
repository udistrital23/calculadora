# language: es

Característica: Resta de dos valores ingresados

  Debo poder restar dos números en bases diferentes [2 a 10] y mostrar el resultado en otra base numérica [2 a 10].

  Escenario: Resta exitosa en bases mixtas
    Dado que el usuario quiere restar dos números
    Cuando el minuendo es "100" en base 2
    Y el sustraendo es "1" en base 10
    Y la base de salida elegida es 2
    Entonces el resultado mostrado debe ser "11"

  Escenario: Resta simple en base 8
    Dado que el usuario quiere restar dos números
    Cuando el minuendo es "40" en base 8
    Y el sustraendo es "20" en base 8
    Y la base de salida elegida es 8
    Entonces el resultado mostrado debe ser "20"

  Escenario: Rechazo por base del sustraendo fuera de rango
    Dado que el usuario quiere restar dos números
    Cuando el minuendo es "100" en base 10
    Y el sustraendo es "50" en base 1
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "La base debe estar en el rango de 2 a 10."

  Escenario: Rechazo por dígito no válido para la base
    Dado que el usuario quiere restar dos números
    Cuando el minuendo es "23" en base 3
    Y el sustraendo es "10" en base 2
    Y la base de salida elegida es 10
    Entonces se debe mostrar un mensaje de error "El dígito '3' no es válido para la base 3"

  Escenario: Rechazo por base de salida fuera de rango
    Dado que el usuario quiere restar dos números
    Cuando el minuendo es "19" en base 10
    Y el sustraendo es "20" en base 7
    Y la base de salida elegida es 13
    Entonces se debe mostrar un mensaje de error "La base de salida 13 está fuera del rango [2-10]"
