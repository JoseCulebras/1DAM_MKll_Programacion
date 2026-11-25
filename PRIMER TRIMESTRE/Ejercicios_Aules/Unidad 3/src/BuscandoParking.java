import java.util.Scanner;

public class BuscandoParking {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] plazasAparcamiento = new int[5][10];
        int opcion;

        try {
            do {
                System.out.println("\n---------------------------------------------------------------");
                System.out.println("- 1. Mostrar estado del aparcamiento                          -");
                System.out.println("- 2. Ocupar una plaza (indicando planta y número de plaza)    -");
                System.out.println("- 3. Liberar una plaza                                        -");
                System.out.println("- 4. Mostrar el número de plazas libres y ocupadas            -");
                System.out.println("- 5. Mostrar la planta con más plantas ocupadas               -");
                System.out.println("- 6. Mostrar el porcentaje de ocupación del aparcamiento      -");
                System.out.println("- 7. Mover un coche                                           -");
                System.out.println("- 0. Salir                                                    -");
                System.out.println("---------------------------------------------------------------");
                System.out.print("\nIntroduce una opción: ");
                opcion = sc.nextInt();

                while (opcion < 0 || opcion > 7){
                    System.out.print("\nERROR: Introduce una número positivo del 1 al 7: ");
                    opcion = sc.nextInt();
                }

                switch (opcion){
                    case 1:
                        mostrarEstadoAparcamiento(plazasAparcamiento);
                        break;

                    case 2:
                        ocuparPlaza(plazasAparcamiento);
                        break;

                    case 3:
                        liberarPlaza(plazasAparcamiento);
                        break;

                    case 4:
                        mostrarNumeroPlazasLibresOcupadas(plazasAparcamiento);
                        break;

                    case 5:
                        mostrarPlantaConMasPlazasOcupadas(plazasAparcamiento);
                        break;

                    case 6:
                        mostrarPorcentajeOcupacion(plazasAparcamiento);
                        break;

                    case 7:
                        moverCoche(plazasAparcamiento);
                        break;
                }
            } while (opcion != 0);

        } catch (Exception e) {
            System.out.println("\nERROR: Debes introducir un número entero y positivo");
        }
    }

    public static void mostrarEstadoAparcamiento(int[][] matriz){

        int contador = 4;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){

                if(matriz[i][j] == 0){
                    System.out.print(" [LIBRE] " + "\t");
                }

                if (matriz[i][j] != 0){
                    System.out.print("[OCUPADO]" + "\t");
                }
            }
            System.out.println("--> Planta Nº" + contador);
            contador--;
        }
    }

    public static void ocuparPlaza(int[][] matriz){
        Scanner sc = new Scanner(System.in);

        int P; //Planta
        int N; //Número de plaza

        try {
            System.out.println("\nIndica la planta (0-4): ");
            P = sc.nextInt();

            while (P < 0 || P > 4){
                System.out.println("\nERROR: Esa planta no es válida.");
                System.out.println("\nIndica otra planta: ");
                P = sc.nextInt();
            }

            if (P == 0){
                P = 4;

            }else if (P == 1){
                P = 3;

            }else if (P == 3){
                P = 1;

            }else if (P == 4){
                P = 0;
            }

            System.out.println("\nIndica el número de plaza (1-10): ");
            N = sc.nextInt();

            while (N < 1 || N > 10){
                System.out.println("\nERROR: Esa plaza no es válida.");
                System.out.println("\nIndica otra plaza de aparcamiento: ");
                N = sc.nextInt();
            }

            N = N - 1;

            if (matriz[P][N] != 0){
                System.out.println("\nERROR: Esa plaza ya está ocupada.");

            }else if (matriz[P][N] == 0){
                matriz[P][N] = 1;
            }

        } catch (Exception e) {
            System.out.println("\nERROR: Debes introducir un número entero y positivo");
        }
    }

    public static void liberarPlaza(int[][] matriz){
        Scanner sc = new Scanner(System.in);

        int P; //Planta
        int N; //Número de plaza

        try {
            System.out.println("\nVamos a liberar una plaza de aparcamiento.");

            System.out.println("\nDe qué planta es la plaza que quieres liberar (0-4): ");
            P = sc.nextInt();

            while (P < 0 || P > 4){
                System.out.println("\nERROR: Esa planta no es válida.");
                System.out.println("\nIndica otra planta: ");
                P = sc.nextInt();
            }

            if (P == 0){
                P = 4;

            }else if (P == 1){
                P = 3;

            }else if (P == 3){
                P = 1;

            }else if (P == 4){
                P = 0;
            }

            System.out.println("\nIndica el número de plaza que quieres liberar: ");
            N = sc.nextInt();

            while (N < 1 || N > 10){
                System.out.println("\nERROR: Esa plaza no es válida.");
                System.out.println("\nIndica otra plaza de aparcamiento: ");
                N = sc.nextInt();
            }

            N = N - 1;

            if (matriz[P][N] == 0){
                System.out.println("\nERROR: Esa plaza NO está ocupada.");
            }

            if (matriz[P][N] != 0){
                matriz[P][N] = 0;
            }

        } catch (Exception e) {
            System.out.println("\nERROR: Debes introducir un número entero y positivo");
        }
    }

    public static void mostrarNumeroPlazasLibresOcupadas(int[][] matriz){

        int contadorPlazaLibre = 0;
        int contadorPlazaOcupada = 0;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){

                if(matriz[i][j] == 0){
                    contadorPlazaLibre++;
                }

                if (matriz[i][j] != 0){
                    contadorPlazaOcupada++;
                }
            }
        }

        System.out.println("\n--------------------------------------");
        System.out.println("- NUMERO DE PLAZAS LIBRES Y OCUPADAS -");
        System.out.println("--------------------------------------");
        System.out.println("\n- Plazas totales = " + (contadorPlazaLibre + contadorPlazaOcupada));
        System.out.println("\n- Plazas libres = " + contadorPlazaLibre);
        System.out.println("\n- Plazas ocupadas = " + contadorPlazaOcupada);
    }

    public static void mostrarPlantaConMasPlazasOcupadas(int[][] matriz){

        int contadorPlantaPlazasOcupadas = 0;
        int contadorTemp = 0;
        int contadorPlanta = 0;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){

                if (i <= matriz.length){
                    if(matriz[i][j] != 0){
                        contadorPlantaPlazasOcupadas++;
                    }
                }
            }

            if (contadorTemp < contadorPlantaPlazasOcupadas){
                contadorTemp = contadorPlantaPlazasOcupadas;
                contadorPlanta = i;

                if (contadorPlanta == 0){
                    contadorPlanta = 4;

                }else if (contadorPlanta == 1){
                    contadorPlanta = 3;

                }else if (contadorPlanta == 3){
                    contadorPlanta = 1;

                }else if (contadorPlanta == 4){
                    contadorPlanta = 0;
                }
            }

            contadorPlantaPlazasOcupadas = 0;
        }

        if (contadorTemp == 0){
            System.out.println("\nERROR: Aún no hay plazas ocupadas.");

        }else{
            System.out.println("\n----------------------------------");
            System.out.println("- PLANTA CON MÁS PLAZAS OCUPADAS -");
            System.out.println("----------------------------------");
            System.out.println("\n- Planta = " + contadorPlanta);
            System.out.print(" (" + contadorTemp + " plazas ocupadas)\n");
        }
    }

    public static void mostrarPorcentajeOcupacion(int[][] matriz){

        int plazasTotales = 50;
        int contadorPlazasOcupadas = 0;
        double porcentajePlazasOcupadas = 0;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){

                if (matriz[i][j] != 0){
                    contadorPlazasOcupadas++;
                }
            }
        }

        porcentajePlazasOcupadas = (double)(contadorPlazasOcupadas * 100) / plazasTotales;

        System.out.println("\n---------------------------------");
        System.out.println("- PORCENTAJE DE PLAZAS OCUPADAS -");
        System.out.println("---------------------------------");
        System.out.println("\n- Porcentaje = " + porcentajePlazasOcupadas + "%");
    }

    public static void moverCoche(int[][] matriz){
        Scanner sc = new Scanner(System.in);

        int P; //Planta original
        int N; //Número de plaza original
        int P2; //Planta nueva
        int N2; //Número de plaza nueva

        try {
            System.out.println("\nVamos a mover un coche: ");
            System.out.println("De qué planta es el coche que quieres mover? (0-4): ");
            P = sc.nextInt();

            while (P < 0 || P > 4){
                System.out.println("\nERROR: Esa planta no es válida.");
                System.out.println("\nIndica otra planta: ");
                P = sc.nextInt();
            }

            if (P == 0){
                P = 4;

            }else if (P == 1){
                P = 3;

            }else if (P == 3){
                P = 1;

            }else if (P == 4){
                P = 0;
            }

            System.out.println("\nCúal es la plaza del coche que quieres mover? (1-10): ");
            N = sc.nextInt();

            while (N < 1 || N > 10){
                System.out.println("\nERROR: Esa plaza no es válida.");
                System.out.println("\nIndica otra plaza: ");
                N = sc.nextInt();
            }

            N = N - 1;

            if (matriz[P][N] == 0){
                System.out.println("\nERROR: Esa plaza NO está ocupada.");

            }else if(matriz[P][N] != 0){
                System.out.println("\nAhora vamos a definir dónde quieres mover el coche.");
                System.out.println("A qué planta quieres mover el coche? (0-4): ");
                P2 = sc.nextInt();

                while (P2 < 0 || P2 > 4){
                    System.out.println("\nERROR: Esa planta no es válida.");
                    System.out.println("\nIndica otra planta: ");
                    P2 = sc.nextInt();
                }

                if (P2 == 0){
                    P2 = 4;

                }else if (P2 == 1){
                    P2 = 3;

                }else if (P2 == 3){
                    P2 = 1;

                }else if (P2 == 4){
                    P2 = 0;
                }

                System.out.println("\nA qué plaza quieres mover el coche? (1-10): ");
                N2 = sc.nextInt();

                while (N2 < 1 || N2 > 10){
                    System.out.println("\nERROR: Esa plaza no es válida.");
                    System.out.println("\nIndica otra plaza: ");
                    N2 = sc.nextInt();
                }

                N2 = N2 - 1;

                if (matriz[P2][N2] != 0){
                    System.out.println("\nERROR: Esa plaza está ocupada.");

                }else if (matriz[P2][N2] == 0){
                    matriz[P][N] = 0;

                    matriz[P2][N2] = 1;
                }
            }

        } catch (Exception e) {
            System.out.println("\nERROR: Debes introducir un número entero y positivo");
        }
    }
}
