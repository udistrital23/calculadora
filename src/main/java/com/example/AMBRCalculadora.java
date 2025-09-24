/*********************************************************************************

Calculadora de operaciones aritméticas básicas, con números de bases entre 2 y 10

*********************************************************************************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class AMBRCalculadora
{

    private Scanner entrada;
    private Numero num1;
    private Numero num2;
    private int baseSalida;
    private Operacion operacion;
    private Numero resultado;

    public AMBRCalculadora() 
    {
        this.entrada = new Scanner(System.in);
    }

    public void iniciar() 
    {
        try {
            obtenerEntradas();
            realizarCalculo();
            mostrarResultado();
        } 
        catch (Exception e) 
        {
            System.err.println("Error: " + e.getMessage());
        } 
        finally 
        {
            entrada.close();
        }
    }

    private void obtenerEntradas() 
    {
        System.out.println("--- Calculadora de Bases Numéricas (2-10) ---");
        
        int tempBase;
        String tempValor;

        // --- Bucle para la primera base ---
        do 
        {
            try 
            {
                System.out.println();
                System.out.print("Ingrese la base del primer número (2-10):    ");
                tempBase = entrada.nextInt();
                validarBase(tempBase);
                break; // Si la validación es correcta, salimos del ciclo.
            } 
            catch (InputMismatchException e) 
            {
                System.out.println();
                System.err.println("Error: La base debe ser un número entero.");
                entrada.nextLine(); // Limpiar el buffer.
            } 
            catch (IllegalArgumentException e) 
            {
                //System.out.println();
                System.err.println("Error: " + e.getMessage());
                entrada.nextLine(); // Limpiar el buffer.
            }
        } while (true);
        
        final int base1 = tempBase;
        entrada.nextLine(); // Consumir el salto de línea.

        // --- Bucle para el primer número ---
        do 
        {
            try 
            {
                System.out.println();
                System.out.print("Ingrese el primer número en base " + base1 + ":    ");
                tempValor = entrada.nextLine();
                this.num1 = new Numero(tempValor, base1);
                break; // Si la validación es correcta, salimos del ciclo.
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println();
                System.err.println("Error: " + e.getMessage());
            }
        } while (true);
        
        // --- Bucle para la segunda base ---
        do 
        {
            try 
            {
                System.out.println();
                System.out.println("------ // ------");
                System.out.println();
                System.out.print("Ingrese la base del segundo número (2-10):    ");
                tempBase = entrada.nextInt();
                validarBase(tempBase);
                break;
            } 
            catch (InputMismatchException e) 
            {
                System.out.println();
                System.err.println("Error: La base debe ser un número entero.");
                entrada.nextLine();
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println();
                System.err.println("Error: " + e.getMessage());
                entrada.nextLine();
            }
        } while (true);
        
        final int base2 = tempBase;
        entrada.nextLine();
        
        // --- Bucle para el segundo número ---
        do 
        {
            try 
            {
                System.out.println();
                System.out.print("Ingrese el segundo número en base " + base2 + ": ");
                tempValor = entrada.nextLine();
                this.num2 = new Numero(tempValor, base2);
                break;
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println();
                System.err.println("Error: " + e.getMessage());
            }
        } while (true);
        
        // --- Bucle para la operación ---
        do 
        {
            try 
            {
                System.out.println();
                System.out.println("------ // ------");
                System.out.println();
                System.out.print("Ingrese la operación (+, -, *, /): ");
                String op = entrada.next();
                switch (op) 
                {
                    case "+":
                        this.operacion = new Suma();
                        break;
                    case "-":
                        this.operacion = new Resta();
                        break;
                    case "*":
                        this.operacion = new Multiplicacion();
                        break;
                    case "/":
                        this.operacion = new Division();
                        break;
                    default:
                        System.out.println();
                        System.err.println("Operación no válida. Intente de nuevo.");
                        continue;
                }
                break;
            } 
            catch (Exception e) 
            {
                System.out.println();
                System.err.println("Error: " + e.getMessage());
            }
        } while (true);

        // --- Bucle para la base del resultado ---
        do 
        {
            try 
            {
                System.out.println();
                System.out.println();
                System.out.print("Ingrese la base del resultado (2-10): ");
                this.baseSalida = entrada.nextInt();
                validarBase(baseSalida);
                break;
            } 
            catch (InputMismatchException e) 
            {
                System.out.println();
                System.err.println("Error: La base debe ser un número entero.");
                entrada.nextLine(); // Limpiar el buffer
            } 
            catch (IllegalArgumentException e) 
            {
                System.out.println();
                System.err.println("Error: " + e.getMessage());
                entrada.nextLine(); // Limpiar el buffer
            }
        } while (true);

    }
    
    private void validarBase(int base) 
    {
        if (base < 2 || base > 10) 
        {
            System.out.println();
            throw new IllegalArgumentException("La base debe estar en el rango de 2 a 10.");
        }
    }

    private void realizarCalculo() 
    {
        double resultadoDecimal = operacion.calcular(num1, num2);
        String resultadoEnBaseSalida = Numero.convertirDeDecimal((int) resultadoDecimal, baseSalida);
        this.resultado = new Numero(resultadoEnBaseSalida, baseSalida);
    }

    private void mostrarResultado() 
    {
        String simboloOperacion = "?";
        if (operacion instanceof Suma) 
        {
            simboloOperacion = "+";
        } 
        else if (operacion instanceof Resta) 
        {
            simboloOperacion = "-";
        } 
        else if (operacion instanceof Multiplicacion) 
        {
            simboloOperacion = "*";
        } 
        else if (operacion instanceof Division) 
        {
            simboloOperacion = "/";
        } 
        
        System.out.println();
        System.out.println();
        System.out.println("----- Resultado -----");
        System.out.println();
        System.out.printf("(%s en base %d) %s (%s en base %d) = %s (en base %d)%n",
                num1.mostrarValor(), num1.mostrarBase(),
                simboloOperacion,
                num2.mostrarValor(), num2.mostrarBase(),
                resultado.mostrarValor(), resultado.mostrarBase());
    }

    public static void main(String[] args) 
    {
        AMBRCalculadora control = new AMBRCalculadora();
        control.iniciar();
    }
}

abstract class Operacion 
{
    public abstract double calcular(Numero num1, Numero num2);
}

class Suma extends Operacion 
{
    @Override
    public double calcular(Numero num1, Numero num2) 
    {
        return num1.convertirADecimal() + num2.convertirADecimal();
    }
}

class Resta extends Operacion 
{
    @Override
    public double calcular(Numero num1, Numero num2) 
    {
        return num1.convertirADecimal() - num2.convertirADecimal();
    }
}

class Multiplicacion extends Operacion 
{
    @Override
    public double calcular(Numero num1, Numero num2) 
    {
        return num1.convertirADecimal() * num2.convertirADecimal();
    }
}

class Division extends Operacion 
{
    @Override
    public double calcular(Numero num1, Numero num2) 
    {
        if (num2.convertirADecimal() == 0) 
        {
            System.out.println();
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return (double) num1.convertirADecimal() / num2.convertirADecimal();
    }
}

class Numero 
{
    private String valor;
    private int base;

    public Numero(String valor, int base) 
    {
        validarBase(base);
        validarValorEnBase(valor, base);
        this.valor = valor;
        this.base = base;
    }
    
    // Método para validar que la base esté en el rango permitido
    private void validarBase(int base) 
    {
        if (base < 2 || base > 10) 
        {
            System.out.println();
            throw new IllegalArgumentException("La base debe estar en el rango de 2 a 10.");
        }
    }

    // Método para validar que cada dígito del número esté en la base ingresada
    private void validarValorEnBase(String valor, int base) 
    {
        for (char digito : valor.toCharArray()) 
        {
            int valorDigito;
            if (Character.isDigit(digito)) 
            {
                valorDigito = Character.getNumericValue(digito);
            } 
            else 
            {
                System.out.println();
                throw new IllegalArgumentException("El carácter '" + digito + "' no es un dígito válido.");
            }

            if (valorDigito >= base) 
            {
                System.out.println();
                throw new IllegalArgumentException("El dígito '" + digito + "' no es válido en la base " + base + ".");
            }
        }
    }
    
    public String mostrarValor() 
    {
        return valor;
    }

    public int mostrarBase() 
    {
        return base;
    }
    
    public int convertirADecimal() 
    {
        return Integer.parseInt(valor, base);
    }

    public static String convertirDeDecimal(int valorDecimal, int base) 
    {
        return Integer.toString(valorDecimal, base);
    }
}
