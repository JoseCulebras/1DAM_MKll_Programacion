import java.util.Scanner;

public class Almazara {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] citas = new int[4][7];
        String[][] dias_semana = new String[4][7];
        int kilos;
        int kilosParaAlmazara;
        float litros;
        String calidad;

        crear_calendario(citas, dias_semana);

        try {
            System.out.print("\nIntroduce el valor a sumar a los posibles 1000 kilos que la almazara puede procesar: ");
            kilos = sc.nextInt();

            rellenar_kilos_dia(kilos, citas);

            System.out.print("\nIntroduce el número de kilos que quieres llevar a la almazara: ");
            kilosParaAlmazara = sc.nextInt();

            System.out.print("\nIntroduce la calidad (suprema/buena/mala/regular): ");
            calidad = sc.next();

            litros = litrosAceite(calidad, kilosParaAlmazara);

            if (litros == -1){
                System.out.print("\nERROR: Calidad no válida.");

            }else{
                System.out.print("\nPara la calidad " + calidad.toLowerCase() + " los litros de aceite que corresponden son: " + litros + " litros");
            }

            System.out.println("\n\n-------------------------------------------");
            System.out.println("| DIAS NECESARIOS PARA REALIZAR EL ACEITE |");
            System.out.println("-------------------------------------------");
            System.out.println(dias_para_hacer_aceite(kilosParaAlmazara, citas, dias_semana));

            System.out.println("\n------------------------------------------");
            System.out.println("| DIAS EN LOS QUE SE LLEVARÁN LAS OLIVAS |");
            System.out.println("------------------------------------------");
            for (int i = 0; i < dias_semana.length; i++){
                for (int j = 0; j < dias_semana[i].length; j++){
                    if (dias_semana[i][j].equals("*")){
                        System.out.printf("%-12s", "*");

                    }else{
                        System.out.printf("%-12s", dias_semana[i][j]);
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("\nERROR: Introduce un valor válido.");
        }
    }

    public static void crear_calendario(int[][] citas, String[][] dias_semana){
        int diaAleatorio;
        int semana;

        for (int i = 0; i < citas.length; i++){
            semana = i;
            diaAleatorio = (int)(Math.random() * citas[i].length);

            for (int j = 0; j < citas[i].length; j++){
                citas[i][j] = 0;
                citas[semana][diaAleatorio] = -1;

                System.out.print(citas[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < dias_semana.length; i++){
            for (int j = 0; j < dias_semana[i].length; j++){
                dias_semana [i][j] = "*";

            }
        }
    }

    public static void rellenar_kilos_dia(int kilos, int[][] citas){
        int numeroAleatorio;

        System.out.println("\n--------------------------------------------");
        System.out.println("| NÚMERO DE KG QUE PUEDES PROCESAR POR DIA |");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < citas.length; i++){
            for (int j = 0; j < citas[i].length; j++){
                numeroAleatorio = (int)(Math.random() * 1000) + 1 + kilos;

                if (citas[i][j] == 0){
                    citas[i][j] = numeroAleatorio;
                }
                System.out.print(" " + citas[i][j] + " " + "\t");
            }

            System.out.println();
        }
    }

    public static float litrosAceite(String calidad, int kilos){
        float litros;
        float litrosPor100k = (float) kilos / 100;

        if (calidad.equalsIgnoreCase("suprema")){
            litros = litrosPor100k * 28;

        }else if (calidad.equalsIgnoreCase("buena")){
            litros = litrosPor100k * 22;

        }else if (calidad.equalsIgnoreCase("regular")){
            litros = litrosPor100k * 15;

        }else if (calidad.equalsIgnoreCase("mala")){
            litros = litrosPor100k * 8;

        }else{
            return -1;
        }

        return litros;
    }

    public static int dias_para_hacer_aceite(int numKilos, int[][] citas, String[][] dias_semana){
        int kilosPendientes = numKilos;
        int diasUsados = 0;

        for (int i = 0; i < citas.length; i++){
            for (int j = 0; j < citas[i].length; j++){
                if (kilosPendientes <= 0){
                    return diasUsados;
                }

                if (citas[i][j] == -1){
                    continue;
                }

                diasUsados++;
                dias_semana[i][j] = dia(j);

                if (citas[i][j] >= kilosPendientes){
                    citas[i][j] -= kilosPendientes;
                    kilosPendientes = 0;
                    return diasUsados;

                }else{
                    kilosPendientes -= citas[i][j];
                    citas[i][j] = 0;
                }
            }
        }

        if (kilosPendientes > 0){
            System.out.println("\nNo hay suficiente capacidad en el mes. Quedan " + kilosPendientes + "kg sin procesar.");
        }

        return diasUsados;
    }

    public static String dia(int num){

        if (num == 0){
            return "Lunes";

        }else if (num == 1){
            return "Martes";

        }else if (num == 2){
            return "Miércoles";

        }else if (num == 3){
            return "Jueves";

        }else if (num == 4){
            return "Viernes";

        }else if (num == 5){
            return "Sábado";

        }else if (num == 6){
            return "Domingo";

        }

        return "";
    }
}
