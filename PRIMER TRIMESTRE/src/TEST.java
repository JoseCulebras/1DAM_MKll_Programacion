import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos a proceder a introducir 6 números enteros...\n");

        // 1. Introducción de la apuesta (matriz 2x3) y reintegro
        int[][] apuesta = introducirApuesta(sc);
        int reintegroApuesta = introducirReintegro(sc);

        // 2. Generación de la combinación ganadora aleatoria (matriz 2x3) y reintegro aleatorio
        int[][] ganadora = generarCombinacionGanadora();
        int reintegroGanador = (int)(Math.random() * 9) + 1;

        // 3. Resultados
        System.out.println("\n------------------");
        System.out.println("-   RESULTADOS   -");
        System.out.println("------------------");

        System.out.print("Tus números son: ");
        imprimirMatriz(apuesta, reintegroApuesta);

        System.out.print("Los números generados son: ");
        imprimirMatriz(ganadora, reintegroGanador);

        int aciertos = contarAciertos(apuesta, ganadora);
        System.out.println("Aciertos: " + aciertos + "/6");

        String aciertoReintegro = (reintegroApuesta == reintegroGanador) ? "si" : "no";
        System.out.println("Reintegro acertado: " + aciertoReintegro);
    }

    // a) Función obligatoria: Comprobar si un número ya ha aparecido en la matriz
    public static boolean contiene(int[][] numeros, int numero) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                if (numeros[i][j] == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    // b) Función obligatoria: Contar los aciertos entre la apuesta y la ganadora
    public static int contarAciertos(int[][] apuesta, int[][] ganadora) {
        int aciertos = 0;
        for (int i = 0; i < apuesta.length; i++) {
            for (int j = 0; j < apuesta[i].length; j++) {
                if (contiene(ganadora, apuesta[i][j])) {
                    aciertos++;
                }
            }
        }
        return aciertos;
    }

    // Método para solicitar y validar la apuesta del usuario en matriz 2x3
    public static int[][] introducirApuesta(Scanner sc) {
        int[][] matriz = new int[2][3];
        int contador = 1;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int numero;
                do {
                    System.out.print("Introduce el número " + contador + ": ");
                    numero = sc.nextInt();

                    if (numero < 1 || numero > 49) {
                        System.out.println("Este número no es válido");
                    } else if (contiene(matriz, numero)) {
                        System.out.println("Este número no es válido (está repetido)");
                    }
                } while (numero < 1 || numero > 49 || contiene(matriz, numero));

                matriz[i][j] = numero;
                contador++;
            }
        }
        return matriz;
    }

    // Método para solicitar y validar el reintegro (1 a 9)
    public static int introducirReintegro(Scanner sc) {
        int reintegro;
        do {
            System.out.print("Ingrese el reintegro (1-9): ");
            reintegro = sc.nextInt();
            if (reintegro < 1 || reintegro > 9) {
                System.out.println("Este número no es válido");
            }
        } while (reintegro < 1 || reintegro > 9);
        return reintegro;
    }

    // Método para generar la combinación ganadora aleatoria (matriz 2x3 sin repetir)
    public static int[][] generarCombinacionGanadora() {
        int[][] matriz = new int[2][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int numero;
                do {
                    numero = (int)(Math.random() * 49) + 1;
                } while (contiene(matriz, numero));
                matriz[i][j] = numero;
            }
        }
        return matriz;
    }

    // Método auxiliar para imprimir las matrices con el formato de barras del ejemplo del PDF
    public static void imprimirMatriz(int[][] matriz, int reintegro) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "|");
            }
        }
        System.out.println(" Reintegro: " + reintegro);
    }
}