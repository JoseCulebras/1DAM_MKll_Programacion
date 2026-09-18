import java.util.Scanner;

public class Ejercicio2_JGC {
    public static void main (String[] args){
        procesoSeleccion();
    }

    public static boolean procesoSeleccion(){
        Scanner scanner = new Scanner(System.in);

        int edad;
        String nombre;
        int anyos;
        double sueldoBrutoAnualAnterior;
        double nominas;
        double sumaNominas = 0;
        double valorIncrementadoNominas;

        System.out.println("\nDime tu edad: ");
        edad = scanner.nextInt();

        if (edad > 40){
            System.out.println("\nQuedas descartado del proceso de selección");
            return false;

        }else{

            System.out.println("\nDime tu nombre: ");
            nombre = scanner.next();

            System.out.println("\nDime los años que tienes trabajados: ");
            anyos = scanner.nextInt();

            System.out.println("\nDime el último sueldo bruto anual que tuviste: ");
            sueldoBrutoAnualAnterior = scanner.nextDouble();

            if(sueldoBrutoAnualAnterior > 30000){
                System.out.println("\nQuedas descartado del proceso de selección");
                return false;
            }else{
                System.out.println("\nEnhorabuena, has sido contratado");
                System.out.println("Introduce tus últimas 5 nóminas: ");

                for(int i = 1; i <= 5; i++){
                    nominas = scanner.nextDouble();

                    sumaNominas += nominas;
                }

                System.out.println("\nLa suma de tus nóminas son: " + sumaNominas);

                if((sumaNominas/5) > 2500){
                    System.out.println("\nEl valor de la nómina mensual incrementará un 5%");

                    valorIncrementadoNominas = (sumaNominas/5) + ((sumaNominas/5) * 5 / 100);

                    System.out.println("\nLa cantidad resultante es: " + valorIncrementadoNominas);

                }else{
                    System.out.println("\nEl valor de la nómina mensual incrementará un 10%");

                    valorIncrementadoNominas = (sumaNominas/5) + ((sumaNominas/5) * 10 / 100);

                    System.out.println("\nLa cantidad resultante es: " + valorIncrementadoNominas);
                }

                return true;
            }
        }
    }
}