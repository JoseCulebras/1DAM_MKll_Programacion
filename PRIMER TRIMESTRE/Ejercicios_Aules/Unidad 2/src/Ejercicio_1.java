import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 1 - Programa que determina si un número positivo, negativo o cero");
        System.out.println("===========================================================================");

        int numero;

        try{
            System.out.println("\nIntroduce un número: ");
            numero = sc.nextInt();

            if (numero == 0){
                System.out.println("\nEl número es igual a cero.");

            }else if (numero > 0){
                System.out.println("\nEl número es mayor a cero.");

            }else{
                System.out.println("\nEl número es menor a cero.");
            }
        }catch (Exception e){
            System.out.println("ERROR: Introduce un número válido (número entero sin decimales)");
        }
    }
}
