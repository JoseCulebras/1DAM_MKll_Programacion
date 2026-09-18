import java.util.Scanner;

public class Ejercicio4_JGC {
    public static void main (String[] args){
        LigaFutbol();
    }

    public static void LigaFutbol(){
        Scanner scanner = new Scanner(System.in);

        String[] arrayNombres = new String[20];
        int[] arrayPuntuacion = new int[20];
        int indiceEquipos = 1;

        for (int i = 0; i < arrayNombres.length; i++){
            System.out.println("\nIntroduce el nombre del equipo Nº" + indiceEquipos + ": ");
            arrayNombres[i] = scanner.nextLine();
            indiceEquipos++;

            arrayPuntuacion[i] = (int) (Math.random() * (65 + 1) + 35);
        }

        int minimoPuntos = 100;
        int maximoPuntos = 0;
        int numeroGanador = 0;
        int numeroUltimo = 0;
        int sumaPuntos = 0;

        for (int i = 0; i < arrayPuntuacion.length; i++){

            sumaPuntos += arrayPuntuacion[i];

            if(arrayPuntuacion[i] > maximoPuntos){
                maximoPuntos = arrayPuntuacion[i];
                numeroGanador = i;
            }

            if(arrayPuntuacion[i] < minimoPuntos){
                minimoPuntos = arrayPuntuacion[i];
                numeroUltimo = i;
            }
        }

        System.out.println("\nRESULTADOS DE LA LIGA DE FUTBOL");
        System.out.println("===============================");

        System.out.println("\n- Equipo ganador: " + arrayNombres[numeroGanador] + "  || Puntos: " + maximoPuntos);
        System.out.println("- Último equipo clasificado: " + arrayNombres[numeroUltimo] + " || Puntos: " + minimoPuntos);

        System.out.println("\n- La puntuación media de los equipos es: " + (sumaPuntos / arrayPuntuacion.length));
    }
}