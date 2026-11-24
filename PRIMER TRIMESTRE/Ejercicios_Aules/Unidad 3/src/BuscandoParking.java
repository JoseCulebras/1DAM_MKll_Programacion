import java.util.Scanner;

public class BuscandoParking {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] plazasAparcamiento = new int[5][10];
        int opcion;

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("- 1. Mostrar estado del aparcamiento                          -");
        System.out.println("- 2. Ocupar una plaza (indicando planta y número de plaza)    -");
        System.out.println("- 3. Liberar una plaza                                        -");
        System.out.println("- 4. Mostrar el número de plazas libres y ocupadas            -");
        System.out.println("- 5. Mostrar la planta con más plantas ocupadas               -");
        System.out.println("- 6. Mostrar el porcentaje de ocupación del aparcamiento      -");
        System.out.println("- 7. Mover un coche                                           -");
        System.out.println("- 0. Salir                                                    -");
        System.out.println("-------------------------------------------------------------");
        System.out.print("\nIntroduce una opción: ");
        opcion = sc.nextInt();

        switch (opcion){
            case 1:
                mostrarEstadoAparcamiento(plazasAparcamiento);
                break;

            case 2:

        }

    }

    public static void mostrarEstadoAparcamiento(int[][] matriz){

        int contador = 4;
        int contadorPrueba = 50;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length + 5; j++){

                if (){

                }
                System.out.print(contadorPrueba + "[LIBRE]" + "\t");
                contadorPrueba--;
            }
            System.out.println("--> Planta Nº" + contador);
            contador--;
        }
    }

    public static void ocuparPlaza(int[][] matriz){
        Scanner sc = new Scanner(System.in);

        int planta;
        int numeroPlaza;
        String libre = "[LIBRE]";

        System.out.println("\nIndica la planta: ");
        planta = sc.nextInt();

        System.out.println("\nIndica el número de plaza: ");
        numeroPlaza = sc.nextInt();

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length + 5; j++){
                System.out.println(matriz[planta][numeroPlaza]);
            }
        }
    }
}
