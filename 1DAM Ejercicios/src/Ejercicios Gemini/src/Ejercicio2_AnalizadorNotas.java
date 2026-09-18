import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2_AnalizadorNotas {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        int numeroNotas;
        int contador = 1;
        double sumaNotas = 0;
        double notaMasAlta = 0;
        int aprobados = 0;

        System.out.println("\nCuántas notas quieres introducir?: ");
        numeroNotas = scanner.nextInt();

        double[] notas = new double[numeroNotas];

        for(int i = 0; i < notas.length; i++){

            System.out.println("\nIntroduce la nota Nº" + contador + ": ");
            notas[i] = scanner.nextDouble();

            contador++;

            sumaNotas += notas[i];

            if (notas[i] > notaMasAlta){
                notaMasAlta = notas[i];
            }

            if (notas[i] >= 5){
                aprobados++;
            }
        }

        System.out.println("\n" + Arrays.toString(notas));

        System.out.println("\n- La nota media de la clase es: " + String.format("%.2f", (sumaNotas/ numeroNotas)));

        System.out.println("\n- La nota más alta es: " + notaMasAlta);

        System.out.println("\n- Alumnos que han aprobado: " + aprobados);
    }
}