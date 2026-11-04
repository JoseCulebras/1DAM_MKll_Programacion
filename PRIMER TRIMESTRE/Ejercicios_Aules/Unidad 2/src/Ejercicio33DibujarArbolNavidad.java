import java.util.Scanner;

public class Ejercicio33DibujarArbolNavidad {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int tamanyo;

        System.out.println("Ejercicio 33: Programa que solicita el tamaño de un triángulo (tamaño de entero positivo)y lo dibuja utilizando asteriscos");
        System.out.println("==========================================================================================================================");

        try {
            System.out.print("\nIntroduce el tamaño del triángulo: ");
            tamanyo = sc.nextInt();

            while(tamanyo <= 2 || tamanyo % 2 == 0){
                System.out.println("\nERROR: Introduce un tamaño válido.");
                System.out.print("(número entero, positivo, mayor que 2 e impar): ");
                tamanyo = sc.nextInt();
            }

            System.out.println("\n--------------------------");
            System.out.println("-    ÁRBOL DE NAVIDAD    -");
            System.out.println("--------------------------");

            for(int i = 1; i <= tamanyo; i++){
                for(int j = 1; j <= tamanyo - i; j++){
                    System.out.print(" ");
                }

                for(int k = 1; k <= (2 * i - 1); k++){
                    System.out.print("*");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("\nERROR: Solo se pueden introducir números enteros y positivos.");
        }
    }
}
