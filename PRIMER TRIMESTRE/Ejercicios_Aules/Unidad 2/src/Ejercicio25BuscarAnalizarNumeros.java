import java.util.Scanner;

public class Ejercicio25BuscarAnalizarNumeros {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 25: Programa que permite introducir números enteros y almacenarlos en un array de 10 posiciones");
        System.out.println("=========================================================================================================\n");

        int[] arrayNumeros = new int[10];
        int numero;
        int contador = 0;
        int sumaNumeros = 0;
        int numeroMayor = 0;
        int numeroMenor = Integer.MAX_VALUE;
        int sumaPares = 0;
        int sumaImpares = 0;
        int contadorNumerosPares = 0;
        int contadorNumerosImpares = 0;

        try {
            while(contador != 10){

                System.out.print("Introduce un número: ");
                numero = sc.nextInt();

                if(numero == 0 || numero == 100){
                    System.out.println("Se ha introducido el número " + numero + ". Finalizando la introducción de datos.\n");
                    break;
                }

                if(numero >= 0){
                    arrayNumeros[contador] = numero;
                    contador++;
                    continue;
                }

                if(numero < 0){
                    System.out.println("El número es negativo y no se almacenará.\n");
                }
            }

            System.out.println("\nNúmeros almacenados: ");
            for (int i = 0; i < arrayNumeros.length; i++){

                if(arrayNumeros[i] != 0){
                    System.out.print(arrayNumeros[i]);
                    System.out.print(" ");

                    if(arrayNumeros[i] > numeroMayor){
                        numeroMayor = arrayNumeros[i];

                    }

                    if(arrayNumeros[i] < numeroMenor){
                        numeroMenor = arrayNumeros[i];
                    }
                }

                sumaNumeros += arrayNumeros[i];

                if(arrayNumeros[i] % 2 == 0 && arrayNumeros[i] > 0){
                    sumaPares += arrayNumeros[i];
                    contadorNumerosPares++;

                }else if (arrayNumeros[i] % 2 != 0){
                    sumaImpares += arrayNumeros[i];
                    contadorNumerosImpares++;
                }
            }

            System.out.println("\n\nCantidad de números introducidos: " + contador);
            System.out.println("Suma de los números: " + sumaNumeros);
            System.out.println("Número mayor: " + numeroMayor);
            System.out.println("Número menor: " + numeroMenor);
            System.out.println("Suma de los números pares: " + sumaPares);
            System.out.println("Suma de los números impares: " + sumaImpares);
            System.out.println("Cantidad de números pares: " + contadorNumerosPares);
            System.out.println("Cantidad de números impares: " + contadorNumerosImpares);

        } catch (Exception e) {
            System.out.println("\nERROR: Solo puedes introducir números enteros.");
        }
    }
}
