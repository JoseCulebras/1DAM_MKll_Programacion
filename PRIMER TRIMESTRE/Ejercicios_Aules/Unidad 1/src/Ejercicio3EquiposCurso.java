import java.util.Scanner;

public class Ejercicio3EquiposCurso {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int numeroEstudiantes;
        int tamanyoEquipos;
        int divisionEquipos;
        int restoEstudiantes;

        System.out.println("\nIntroduce el número de estudiantes en el grupo: ");
        numeroEstudiantes = sc.nextInt();

        System.out.println("\nIntroduce el tamaño de los equipos que se formarán: ");
        tamanyoEquipos = sc.nextInt();

        divisionEquipos = numeroEstudiantes / tamanyoEquipos;
        restoEstudiantes = numeroEstudiantes - (divisionEquipos * tamanyoEquipos);

        System.out.println("\nNúmero de equipos: " + divisionEquipos);

        System.out.println("\nEstudiantes sin equipo: " + restoEstudiantes);
    }
}
