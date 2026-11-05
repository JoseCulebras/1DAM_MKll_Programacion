import java.util.Scanner;

public class PRIMITIVA {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int numero;
        int[] numerosApuesta = new int[6];
        int contadorNumeros = 1;
        boolean repetido = false;
        int numeroReintegro;
        int numerosIntroducidos = 0;

        for(int i = 0; i < numerosApuesta.length; i++){
            System.out.print("\nIntroduce el número " + contadorNumeros + ": ");
            numero = sc.nextInt();

            while(numero < 1 || numero > 49){
                System.out.print("\nERROR: Introduce un número comprendido entre 1 y 49: ");
                numero = sc.nextInt();
            }

            for(int j = 0; j < i; j++){
                if (numero == numerosApuesta[j]){
                    repetido = true;
                    break;
                }
            }

            while(repetido){
                System.out.print("\nERROR: Introduce un número distinto a los anteriores: ");
                numero = sc.nextInt();

                while(numero < 1 || numero > 49){
                    System.out.print("\nERROR: Introduce un número comprendido entre 1 y 49: ");
                    numero = sc.nextInt();
                }

                repetido = false;

                for(int j = 0; j < i; j++){
                    if (numero == numerosApuesta[j]){
                        repetido = true;
                        break;
                    }
                }
            }

            numerosApuesta[i] = numero;
            numerosIntroducidos += numero;
            contadorNumeros++;
        }

        System.out.print("\nIntroduce el reintegro: ");
        numeroReintegro = sc.nextInt();

        while(numeroReintegro < 1 || numeroReintegro > 9){
            System.out.print("\nERROR: Introduce un número comprendido entre 1 y 9: ");
            numeroReintegro = sc.nextInt();
            numerosIntroducidos += numeroReintegro;
        }

        //Introducción de la apuesta
        System.out.println("Vamos a proceder a introducir 6 números enteros...");
        primerosNumeros();

        //Generación de la combinación ganadora
        combinacionGanadora();

        System.out.println("\n------------------");
        System.out.println("-   RESULTADOS   -");
        System.out.println("------------------");

        System.out.print("\nNúmeros introducidos: ");
    }

    public static void primerosNumeros(){
        Scanner sc = new Scanner(System.in);

        int numero;
        int[] numerosApuesta = new int[6];
        int contadorNumeros = 1;
        boolean repetido = false;
        int numeroReintegro;
        int numerosIntroducidos = 0;

        for(int i = 0; i < numerosApuesta.length; i++){
            System.out.print("\nIntroduce el número " + contadorNumeros + ": ");
            numero = sc.nextInt();

            while(numero < 1 || numero > 49){
                System.out.print("\nERROR: Introduce un número comprendido entre 1 y 49: ");
                numero = sc.nextInt();
            }

            for(int j = 0; j < i; j++){
                if (numero == numerosApuesta[j]){
                    repetido = true;
                    break;
                }
            }

            while(repetido){
                System.out.print("\nERROR: Introduce un número distinto a los anteriores: ");
                numero = sc.nextInt();

                while(numero < 1 || numero > 49){
                    System.out.print("\nERROR: Introduce un número comprendido entre 1 y 49: ");
                    numero = sc.nextInt();
                }

                repetido = false;

                for(int j = 0; j < i; j++){
                    if (numero == numerosApuesta[j]){
                        repetido = true;
                        break;
                    }
                }
            }

            numerosApuesta[i] = numero;
            numerosIntroducidos += numero;
            contadorNumeros++;
        }

        System.out.print("\nIntroduce el reintegro: ");
        numeroReintegro = sc.nextInt();

        while(numeroReintegro < 1 || numeroReintegro > 9){
            System.out.print("\nERROR: Introduce un número comprendido entre 1 y 9: ");
            numeroReintegro = sc.nextInt();
            numerosIntroducidos += numeroReintegro;
        }
    }

    public static void combinacionGanadora(){

        int[] combinacion = new int[6];
        int numero;
        int reintegro;
        boolean repetido;

        for(int i = 0; i < combinacion.length; i++){

            repetido = true;

            do{
                repetido = false;
                numero = (int)(Math.random() * 49) + 1;

                for(int j = 0; j < i; j++){
                    if(combinacion[j] == numero){
                        repetido = true;
                        break;
                    }
                }
            }while(repetido);

            combinacion[i] = numero;
        }

        reintegro = (int)(Math.random() * 9) + 1;

//        System.out.println("Números generados: ");
//
//        for(int i = 0; i < combinacion.length; i++){
//            System.out.print(combinacion[i] + " ");
//        }
//
//        System.out.print(reintegro);
    }
}
