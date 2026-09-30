import java.util.Scanner;
public class intercambio
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // Faltaba poner esta línea
// declaración de variables
        int x, y;
        int temp = 0; // Para guardar el dato de una de las variables y que no se pierda el otro valor es necesario crear una variable temporal
// Introducción de datos
        System.out.print("Enter value for x ");
        x = sc.nextInt();
        System.out.print("Enter value for y ");
        y = sc.nextInt();
// Código que intercambia los valores
        temp = x; // Se guarda el valor de x en la variable temp para que no se pierda
        x = y;
        y = temp; // Se le asigna el valor de temp a y

//muestra resultado
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}