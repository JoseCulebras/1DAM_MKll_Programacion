import java.util.Scanner;

public class PRIMITIVA {
    public static void main (String[] args){

        int[][] numerosApuesta;
        int apuestaReintegro;
        int[][]numeroGanador;
        int reintegroGanador;
        int aciertos;
        String aciertoReintegro;

        //Introducción de la apuesta
        System.out.println("--------------------------------");
        System.out.println("- Vamos a simular la primitiva -");
        System.out.println("--------------------------------");
        numerosApuesta = introducirNumerosApuesta();
        apuestaReintegro = introducirNumeroReintegro();

        //Generación de la combinación ganadora
        numeroGanador = generarNumeroGanador();
        reintegroGanador = (int)(Math.random() * 9) + 1;

        //Resultados
        System.out.println("\n------------------");
        System.out.println("-   RESULTADOS   -");
        System.out.println("------------------");

        System.out.println("\nLos números que has introducido son: ");
        imprimirMatriz(numerosApuesta, apuestaReintegro);

        System.out.println("\nLos números generados son: ");
        imprimirMatriz(numeroGanador, reintegroGanador);

        aciertos = contarAciertos(numerosApuesta, numeroGanador);
        System.out.println("\nAciertos: " + aciertos + "/6");

        if (apuestaReintegro == reintegroGanador){
            aciertoReintegro = "Sí";

        }else{
            aciertoReintegro = "No";
        }

        System.out.println("Reintegro acertado: " + aciertoReintegro);
    }

    public static boolean contiene(int[][] numeros, int numero){
        for (int i = 0; i < numeros.length; i++){
            for (int j = 0; j < numeros[i].length; j++){
                if (numeros[i][j] == numero){
                    return true;
                }
            }
        }
        return false;
    }

    public static int contarAciertos(int[][] apuesta, int[][] ganadora){
        int aciertos = 0;

        for (int i = 0; i < apuesta.length; i++){
            for (int j = 0; j < apuesta[i].length; j++){
                if(contiene(ganadora, apuesta[i][j])){
                    aciertos++;
                }
            }
        }
        return aciertos;
    }

    public static int[][]introducirNumerosApuesta(){
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[2][3];
        int contador = 1;
        int numero;

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                do{
                    System.out.print("\n-> Introduce el número " + contador + ": ");
                    numero = sc.nextInt();

                    if (numero < 1 || numero > 49){
                        System.out.println("\nERROR: Introduce un número comprendido entre 1 y 49.");

                    }else if (contiene(matriz, numero)){
                        System.out.println("\nERROR: Introduce un número distinto a los anteriores.");
                    }

                }while (numero < 1 || numero > 49 || contiene(matriz, numero));

                matriz[i][j] = numero;
                contador++;
            }
        }
        return matriz;
    }

    public static int introducirNumeroReintegro(){
        Scanner sc = new Scanner(System.in);

        int reintegro;

        do{
            System.out.print("\n-> Introduce el reintegro: ");
            reintegro = sc.nextInt();

            if (reintegro < 1 || reintegro > 9){
                System.out.println("\nERROR: Introduce un número comprendido entre 1 y 9.");
            }

        }while (reintegro < 1 || reintegro > 9);

        return reintegro;
    }

    public static int[][] generarNumeroGanador(){
        int[][] matriz = new int[2][3];

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                int numero;

                do{
                    numero = (int)(Math.random() * 49) + 1;

                }while(contiene(matriz, numero));
                matriz[i][j] = numero;
            }
        }

        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz, int reintegro){
        System.out.print("|");
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + "|");
            }
        }
        System.out.println(" Reintegro: " + reintegro);
    }
}
