public class Ejercicio31MatrizTranspuesta {
    public static void main (String[] args){

        System.out.println("Ejercicio 31: Programa que genera una matriz 3x4 con números enteros aleatorios entre 1 y 20 junto a otra matriz transpuesta");
        System.out.println("============================================================================================================================");

        int filas = 3;
        int columnas = 4;
        int temp = 0;
        int[][] matrizOriginal = new int[filas][columnas];
        int[][] matrizTranspuesta;

        System.out.println("\nMatriz original (3x4):\n");

        for (int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                matrizOriginal[i][j] = (int)(Math.random() * 20) + 1;
                System.out.print(matrizOriginal[i][j] + "\t");
            }
            System.out.println();
        }

        temp = filas;
        filas = columnas;
        columnas = temp;

        matrizTranspuesta = new int[filas][columnas];

        System.out.println("\n\nMatriz transpuesta (4x3):\n");

        for (int i = 0; i < matrizOriginal.length; i++){
            for (int j = 0; j < matrizOriginal[i].length; j++){
                matrizTranspuesta[j][i] = matrizOriginal[i][j];
            }
        }

        for(int i = 0; i < matrizTranspuesta.length; i++){
            for(int j = 0; j < matrizTranspuesta[i].length; j++){
                System.out.print(matrizTranspuesta[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
