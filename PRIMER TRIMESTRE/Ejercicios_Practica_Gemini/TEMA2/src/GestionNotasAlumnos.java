import java.util.Scanner;

public class GestionNotasAlumnos {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String nombre;
        String regex = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(\\s+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)+$";
        String[] nombresAsignaturas = {"Programación", "Bases de datos", "Entornos"};
        double[] notasAlumnos = new double[3];
        int contador = 0;
        double sumaNotas = 0;
        double notaMedia;

        System.out.println("\nIntroduce el nombre del alumno: ");
        nombre = sc.nextLine();

        while(!nombre.matches(regex)){
            System.out.println("\nERROR: Ese nombre no es válido.");
            System.out.println("Introduce otro nombre por favor: ");
            nombre = sc.nextLine();
        }

        for(int i = 0; i < nombresAsignaturas.length; i++){

            System.out.println("\nIntroduce la nota de la asignatura de " + nombresAsignaturas[i] + ": ");
            notasAlumnos[i] = sc.nextDouble();

            if(notasAlumnos[i] < 0 && notasAlumnos[i] > 10){
                while(notasAlumnos[i] > 0 || notasAlumnos[i] < 10){
                    System.out.println("\nIntroduce una nota válida de la asignatura de " + nombresAsignaturas[i] + ": ");
                    notasAlumnos[i] = sc.nextDouble();
                }
            }

            sumaNotas += notasAlumnos[i];

            contador++;
        }

        notaMedia = sumaNotas / 3;

        if(notaMedia < 5){
            System.out.println("\nSUSPENSO");

        }else if(notaMedia >= 5 && notaMedia < 7) {
            System.out.println("\nAPROBADO");

        }else if(notaMedia >= 7 && notaMedia < 9) {
            System.out.println("\nNOTABLE");

        }else if(notaMedia >= 9) {
            System.out.println("\nSOBRESALIENTE");
        }
    }
}
