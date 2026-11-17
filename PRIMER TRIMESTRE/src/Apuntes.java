import java.util.Scanner;

public class Apuntes { //Buscaminas
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = 4;
        int columnas = 4;
        int totalMinas = 3;

        // 1. Matriz real donde se colocan las minas (-1) y los números de pistas
        int[][] tableroJuego = new int[filas][columnas];

        // 2. Matriz visible para el usuario (lo que va destapando: '*' oculto, números o 'X')
        char[][] tableroVisible = new char[filas][columnas];

        // Inicializar el tablero visible con asteriscos
        inicializarTableroVisible(tableroVisible);

        // Colocar las minas de forma aleatoria
        colocarMinas(tableroJuego, totalMinas);

        // Calcular las pistas (números alrededor de las minas)
        calcularPistas(tableroJuego);

        boolean juegoTerminado = false;
        int casillasDestapadas = 0;
        int casillasObjetivo = (filas * columnas) - totalMinas; // Cuántas hay que abrir para ganar

        while (!juegoTerminado) {
            mostrarTablero(tableroVisible);

            System.out.print("\nIntroduce la fila (0 a " + (filas - 1) + "): ");
            int f = sc.nextInt();
            System.out.print("Introduce la columna (0 a " + (columnas - 1) + "): ");
            int c = sc.nextInt();

            // Validar que las coordenadas estén dentro del tablero
            if (f < 0 || f >= filas || c < 0 || c >= columnas) {
                System.out.println("¡Coordenadas fuera de rango! Inténtalo de nuevo.");
                continue;
            }

            // Comprobar si ha pisado una mina
            if (tableroJuego[f][c] == -1) {
                System.out.println("\n ¡BOOM! Has pisado una mina. ¡Has perdido!");
                revelarTableroCompleto(tableroJuego, tableroVisible);
                mostrarTablero(tableroVisible);
                juegoTerminado = true;
            } else {
                // Si es una casilla segura, la abrimos (si no estaba abierta ya)
                if (tableroVisible[f][c] == '*') {
                    // Convertimos el número de pistas a carácter para mostrarlo
                    tableroVisible[f][c] = (char) (tableroJuego[f][c] + '0');
                    casillasDestapadas++;

                    // Comprobar si ha ganado
                    if (casillasDestapadas == casillasObjetivo) {
                        System.out.println("\n ¡Enhorabuena! Has despejado el campo minado sin explotar.");
                        revelarTableroCompleto(tableroJuego, tableroVisible);
                        mostrarTablero(tableroVisible);
                        juegoTerminado = true;
                    }
                } else {
                    System.out.println("Ya habías abierto esta casilla.");
                }
            }
        }
    }

    // Método para rellenar el tablero visible con '*'
    public static void inicializarTableroVisible(char[][] visible) {
        for (int i = 0; i < visible.length; i++) {
            for (int j = 0; j < visible[i].length; j++) {
                visible[i][j] = '*';
            }
        }
    }

    // Método para colocar minas (-1) de forma aleatoria
    public static void colocarMinas(int[][] juego, int minas) {
        int colocadas = 0;
        while (colocadas < minas) {
            int f = (int) (Math.random() * juego.length);
            int c = (int) (Math.random() * juego[0].length);

            if (juego[f][c] != -1) { // Si no hay mina ya ahí
                juego[f][c] = -1;
                colocadas++;
            }
        }
    }

    // Método para calcular las pistas numéricas según las minas vecinas
    public static void calcularPistas(int[][] juego) {
        int filas = juego.length;
        int columnas = juego[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (juego[i][j] == -1) continue; // Si es mina, se queda en -1

                int contadorMinasVecinas = 0;

                // Revisar las 8 casillas de alrededor
                for (int df = -1; df <= 1; df++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nf = i + df;
                        int nc = j + dc;

                        // Comprobar que la celda vecina esté dentro de los límites
                        if (nf >= 0 && nf < filas && nc >= 0 && nc < columnas) {
                            if (juego[nf][nc] == -1) {
                                contadorMinasVecinas++;
                            }
                        }
                    }
                }
                juego[i][j] = contadorMinasVecinas;
            }
        }
    }

    // Método para mostrar el tablero por consola
    public static void mostrarTablero(char[][] visible) {
        System.out.println("\n    TABLERO ACTUAL:");
        System.out.print("  ");
        for (int j = 0; j < visible[0].length; j++) {
            System.out.print(" " + j);
        }
        System.out.println();

        for (int i = 0; i < visible.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < visible[i].length; j++) {
                System.out.print(visible[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para mostrar todo el tablero al terminar la partida
    public static void revelarTableroCompleto(int[][] juego, char[][] visible) {
        for (int i = 0; i < juego.length; i++) {
            for (int j = 0; j < juego[i].length; j++) {
                if (juego[i][j] == -1) {
                    visible[i][j] = 'X'; // 'X' representa la mina
                } else {
                    visible[i][j] = (char) (juego[i][j] + '0');
                }
            }
        }
    }
}