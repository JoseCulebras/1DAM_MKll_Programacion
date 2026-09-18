import java.util.Scanner;

public class RETO_2 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        double longitudFlecos;
        int totalPiezas = 0;
        double promedioLongitud = 0;
        double totalLongitud = 0;
        int contador = 1;

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Introduce la longitud de los flecos de tela (cm) (0 para salir)");
        System.out.println("---------------------------------------------------------------");

        do{
            System.out.println("\nTela Nº" + contador + ": ");
            longitudFlecos = scanner.nextDouble();

            if(esValido(longitudFlecos)){
                totalPiezas++;
                contador++;
                totalLongitud += longitudFlecos;

            }else if(longitudFlecos != 0){
                System.out.println("\nERROR");
                System.out.println("Longitud no válida (Debe estar entre 1.0 y 20.0 cm).");
            }

        }while(longitudFlecos != 0);

        if (totalPiezas > 0) {
            promedioLongitud = totalLongitud / totalPiezas;
        }

        mostrarResultados(totalPiezas, promedioLongitud);

        scanner.close();
    }

    public static boolean esValido(double longitud){
        return longitud >= 1 && longitud <= 20;
    }

    public static void mostrarResultados(int totalPiezas, double promedioLongitud){
        System.out.println("\n    RESULTADOS DE LA PRODUCCIÓN     ");
        System.out.println("===================================");
        System.out.println("\n- El total de las piezas válidas son: " + totalPiezas);
        System.out.println("- El promedio de longitud de las piezas válidas es: " + promedioLongitud + " cm");
    }
}
