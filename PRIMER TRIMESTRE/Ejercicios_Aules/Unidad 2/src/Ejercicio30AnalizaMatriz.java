public class Ejercicio30AnalizaMatriz {
    public static void main (String[] args){

        System.out.println("Ejercicio 30: Programa que genera una matriz de 3 filas y 4 columnas de números enteros aleatorios entre 1 y 10 en forma de tabla y muestra la suma de los números, el número mayor y el menor y la suma de cada fila y columna");
        System.out.println("===============================================================================================================================================================================================================================");

        System.out.println("\n----------");
        System.out.println("- Matriz -");
        System.out.println("----------");

        int filas = 3;
        int columnas = 4;
        int[][] matriz = new int[filas][columnas];
        int sumaNumeros = 0;
        int numeroMayor = 0;
        int numeroMenor = Integer.MAX_VALUE;
        int sumaFila;
        int sumaColumna;

        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
//                numero = (int)(Math.random() * 10) + 1;
//                System.out.print(numero + "\t");
                matriz[i][j] = (int)(Math.random() * 10) + 1;
                System.out.print(matriz[i][j] + "\t");

                sumaNumeros += matriz[i][j];

                if(matriz[i][j] > numeroMayor){
                    numeroMayor = matriz[i][j];
                }

                if(matriz[i][j] < numeroMenor){
                    numeroMenor = matriz[i][j];
                }
            }
            System.out.println();
        }

        System.out.println("\nSuma de todos los números: " + sumaNumeros);
        System.out.println("Número mayor: " + numeroMayor);
        System.out.println("Número menor: " + numeroMenor + "\n");

        for(int i = 0; i < filas; i++){
            sumaFila = 0;
            for(int j = 0; j < columnas; j++){
                sumaFila += matriz[i][j];
            }
            System.out.println("Suma de la fila " + (i + 1) + ": " + sumaFila);
        }

        for(int j = 0; j < columnas; j++){
            sumaColumna = 0;
            for(int i = ){

            }
        }

//        System.out.println();
    }
}
