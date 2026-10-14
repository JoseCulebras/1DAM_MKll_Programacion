import java.util.Scanner;

public class Ejercicio14ClasificacionAsignatura {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 14: Programa que muestra un mensaje indicando el tipo de asignatura elegido");
        System.out.println("=====================================================================================");

        int contador = 1;
        int opcion;

        System.out.println("----------ASIGNATURAS----------\n");

        for (TipoAsignatura asignatura : TipoAsignatura.values()){

            System.out.println(contador + ". " + asignatura.name().replace("_", " "));
            contador++;
        }

        System.out.println("\nSelecciona una asignatura [1-" + TipoAsignatura.values().length + "]: ");
        opcion = sc.nextInt();

        TipoAsignatura eleccion = TipoAsignatura.values()[opcion - 1];

        switch (eleccion){
            case PROGRAMACION:
                System.out.println("\nHas seleccionado: " + TipoAsignatura.PROGRAMACION);
                break;

            case BASES_DE_DATOS:
                System.out.println("\nHas seleccionado: " + TipoAsignatura.BASES_DE_DATOS.name().replace("_", " "));
                break;

            case ENTORNOS_DE_DESARROLLO:
                System.out.println("\nHas seleccionado: " + TipoAsignatura.ENTORNOS_DE_DESARROLLO.name().replace("_", " "));
                break;

            case LENGUAJES_DE_MARCAS:
                System.out.println("\nHas seleccionado: " + TipoAsignatura.LENGUAJES_DE_MARCAS.name().replace("_", " "));
                break;
        }
    }

    enum TipoAsignatura{
        PROGRAMACION, BASES_DE_DATOS, ENTORNOS_DE_DESARROLLO, LENGUAJES_DE_MARCAS
    }
}
