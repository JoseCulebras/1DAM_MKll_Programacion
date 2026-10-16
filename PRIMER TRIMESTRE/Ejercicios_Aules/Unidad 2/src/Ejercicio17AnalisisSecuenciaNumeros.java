import java.util.Scanner;

public class Ejercicio17AnalisisSecuenciaNumeros {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 17: Programa que solicita números enteros hasta que se introduce un cero y muestra la suma de todos los números positivos, el número mayor, el número menor y la cantidad de números positivos introducidos");
        System.out.println("=====================================================================================================================================================================================================================");

        int numero;
        int sumaNumeros = 0;
        int numeroMayor = 0;
        int numeroMenor = Integer.MAX_VALUE;
        int contador = 0; //Contador de la cantidad de números
        int cantidadNumerosPositivos;

        System.out.println("\nIntroduce 0 para detener el programa");
        System.out.println("------------------------------------");

        do{
            System.out.println("Introduce un número: ");
            numero = sc.nextInt();

            if(numero > 0){
                sumaNumeros += numero;
                contador++;

                if(numero > numeroMayor){
                    numeroMayor = numero;

                }else if(numero < numeroMenor){
                    numeroMenor = numero;
                }
            }

        }while(numero != 0);

        cantidadNumerosPositivos = contador;

        System.out.println("\nSuma: " + sumaNumeros);
        System.out.println("Mayor: " + numeroMayor);
        System.out.println("Menor: " + numeroMenor);
        System.out.println("Cantidad de números positivos introducidos: " + cantidadNumerosPositivos);
    }
}
