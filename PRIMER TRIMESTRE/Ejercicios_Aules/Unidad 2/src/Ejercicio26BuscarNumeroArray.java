import java.util.Scanner;

public class Ejercicio26BuscarNumeroArray {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 26: Programa que genera 15 números enteros aleatorios y solicita al usuario un número a buscar, mostrando cúantas veces y dónde aparece");
        System.out.println("=================================================================================================================================================");

        int[] arrayNumerosAleatorios = new int[15];
        int numeros;
        int numeroABuscar;
        int[] posiciones = new int[15];
        int contadorVecesEncontrado = 0;
        String letra;

        System.out.println("\nNúmeros generados: ");

        for(int i = 0; i < arrayNumerosAleatorios.length; i++){
            numeros = (int)(Math.random() * 41) + 10;
            arrayNumerosAleatorios[i] += numeros;

            System.out.print(numeros);
            System.out.print(" ");
        }

        System.out.println("\n");

        try {
            do{
                System.out.print("\nIntroduce el número que deseas buscar: ");
                numeroABuscar = sc.nextInt();


                for(int i = 0; i < arrayNumerosAleatorios.length; i++){

                    if(numeroABuscar == arrayNumerosAleatorios[i]){
                        posiciones[contadorVecesEncontrado] = i;
                        contadorVecesEncontrado++;
                    }
                }

                if(contadorVecesEncontrado == 0){
                    System.out.print("\nEl número " + numeroABuscar + " no se encuentra en el array.");

                }else{
                    System.out.print("\nEl número " + numeroABuscar + " aparece en la posición: ");

                    for(int i = 0; i < contadorVecesEncontrado; i++){

                        if(i == 0){
                            System.out.print((posiciones[i] + 1));

                        }else if(i == contadorVecesEncontrado - 1){
                            System.out.print(" y " + (posiciones[i] + 1));

                        }else{
                            System.out.print(", " + (posiciones[i] + 1));
                        }
                    }
                }

                if(contadorVecesEncontrado == 1){
                    System.out.println("\nEl número " + numeroABuscar + " aparece " + contadorVecesEncontrado + " vez.");

                }else if(contadorVecesEncontrado >= 1){
                    System.out.println("\nEl número " + numeroABuscar + " aparece " + contadorVecesEncontrado + " veces.");
                }else{
                    System.out.println("\n");
                }

                contadorVecesEncontrado = 0;



                System.out.println("\n¿Deseas buscar otro número? (S/N): ");
                letra = sc.next();

                while(!letra.equalsIgnoreCase("n") && !letra.equalsIgnoreCase("s")){
                    System.out.println("\nIntroduce un valor válido (S/N): ");
                    letra = sc.next();
                }

            }while(letra.equalsIgnoreCase("s"));

            System.out.println("\nFin del programa.");

        } catch (Exception e) {
            System.out.println("\nERROR: Introduce un valor válido.");
        }
    }
}
