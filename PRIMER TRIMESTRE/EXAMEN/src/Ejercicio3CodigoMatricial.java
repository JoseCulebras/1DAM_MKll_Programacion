import java.util.Scanner;

public class Ejercicio3CodigoMatricial {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] numeros = new int[5][4];
        int opcion;

        System.out.println("\nMatriz original: ");

        for (int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                numeros[i][j] = (int)(Math.random() * 99) + 10;
                System.out.print(numeros[i][j] + "\t");
            }
            System.out.println();
        }

        String menu = """
        \n--- CÓDIGO MATRICIAL ---
        1. Desplazar una fila
        2. Desplazar una columna
        3. Intercambiar dos filas
        4. Intercambiar dos columnas
        0. Salir
        Selecciona una opción: 
        """;


        do {

            System.out.print(menu);
            opcion = sc.nextInt();

            // tu código

            switch (opcion) {
                case 1 -> {
                    desplazarUnaFila(numeros);
                }
                case 2 -> {
                    desplazarUnaColumna(numeros);
                }
                case 3 -> {
                    intercambiarDosFilas(numeros);
                }
                case 4 -> {
                    intercambiarDosColumnas(numeros);
                }
                case 0 -> {
                    System.out.println("Fin del programa");
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }

        } while (opcion != 0);
    }

    public static void desplazarUnaFila(int[][] numeros){
        Scanner sc = new Scanner(System.in);

        int valor;

        System.out.println("Vamos a desplazar una fila. Introduce el valor entre el 1 y el 5: ");
        valor = sc.nextInt();

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[i].length; j++){

                if (i <= valor){

                }

                System.out.print(numeros[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void desplazarUnaColumna(int[][] numeros){
        Scanner sc = new Scanner(System.in);

        int valor;

        System.out.println("Vamos a desplazar una fila. Introduce el valor entre el 1 y el 5: ");
        valor = sc.nextInt();

        for(int i = 0; i < numeros.length; i++){

            if (i <= valor){

            }

            for(int j = 0; j < numeros[i].length; j++){
                System.out.print(numeros[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void intercambiarDosFilas(int[][] numeros){
        Scanner sc = new Scanner(System.in);

        int valor;

        System.out.println("Vamos a desplazar una fila. Introduce el valor entre el 1 y el 5: ");
        valor = sc.nextInt();

        for(int i = 0; i < numeros.length; i++){

            if (i <= valor){

            }

            for(int j = 0; j < numeros[i].length; j++){
                System.out.print(numeros[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void intercambiarDosColumnas(int[][] numeros){
        Scanner sc = new Scanner(System.in);

        int valor;

        System.out.println("Vamos a desplazar una fila. Introduce el valor entre el 1 y el 5: ");
        valor = sc.nextInt();

        for(int i = 0; i < numeros.length; i++){

            if (i <= valor){

            }

            for(int j = 0; j < numeros[i].length; j++){
                System.out.print(numeros[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
