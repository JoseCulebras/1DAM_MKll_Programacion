import java.util.Scanner;

public class GestionNotasAlumnos {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String nombre;
        String regex = "^[A-Z][a-z]+\\s[A-Z][a-z]+$";
        String[] nombresAsignaturas = new String[3];
        double[] notasAlumnos = new double[3];

        System.out.println("\nIntroduce el nombre del alumno: ");
        nombre = sc.nextLine();

        do{
            System.out.println("\nERROR: Ese nombre no es válido.");
            System.out.println("Introduce otro nombre por favor: ");
            nombre = sc.nextLine();

        }while(!nombre.matches(regex));

        for(int i = 0; i < nombresAsignaturas.length){

        }
    }
}
