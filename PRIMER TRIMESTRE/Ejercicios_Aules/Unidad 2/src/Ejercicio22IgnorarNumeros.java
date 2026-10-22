import java.util.Scanner;

public class Ejercicio22IgnorarNumeros {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 22: Programa que solicita números enteros hasta que se introduzca un 0, mostrándo únicamente los positivos");
        System.out.println("====================================================================================================================");

        int numero;

        try {
            System.out.print("\nIntroduce un número: ");
            numero = sc.nextInt();

            while(numero != 0){

                if(numero > 0){
                    System.out.println("Número válido: " + numero);
                    System.out.print("\nIntroduce un número: ");
                    numero = sc.nextInt();
                    continue;
                }

                if(numero < 0){
                    System.out.println("El número es negativo. Se ignora.");
                    System.out.print("\nIntroduce un número: ");
                    numero = sc.nextInt();
                }
            }

            System.out.println("\nFin del programa.");

        } catch (Exception e) {
            System.out.println("\nERROR: Debes introducir un número entero.");
        }
    }
}
