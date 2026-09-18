import java.util.Scanner;

public class RETO_1 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        double notaMedia;
        double sumaNotas = 0;
        int contadorAlumnos = 0;
        double nota;
        int aprobado = 0;
        int suspenso = 0;

        System.out.println("\n------------------------------------------------------------");
        System.out.println("Validador de Notas (Introduce un número negativo para salir)");
        System.out.println("------------------------------------------------------------");

        do{
            System.out.println("\nIntroduce una nota de un alumno: ");
            nota = scanner.nextDouble();

            if (nota >= 0) {
                if (nota <= 10) {
                    sumaNotas += nota;
                    contadorAlumnos++;

                    if (nota >= 5) {
                        aprobado++;

                    }else{
                        suspenso++;
                    }

                } else {
                    System.out.println("Error: La nota no puede ser mayor que 10.");
                }
            }

        }while(nota >= 0);

        if (contadorAlumnos > 0) {

            notaMedia = sumaNotas / contadorAlumnos;

            System.out.println("\n- Nota media de clase: " + notaMedia);
            System.out.println("- Alumnos aprobados: " + aprobado);
            System.out.println("- Alumnos suspensos: " + suspenso);

        } else {
            System.out.println("\nNo se introdujeron notas válidas.");
        }

        scanner.close();
    }
}