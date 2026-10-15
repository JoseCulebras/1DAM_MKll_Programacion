import java.util.Scanner;

public class Ejercicio16Conversor {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 16: Programa que muestra una serie de tipos de conversion a elegir");
        System.out.println("============================================================================");

        int contador = 1;
        int opcion;
        double valor1;
        double valor2;

        System.out.println("\n-----------CONVERSOR-----------");

        for (TipoConversion conversion : TipoConversion.values()){
            System.out.println(contador + ". " + conversion.name().replace("_", " -> "));
            contador++;
        }

        System.out.println("\nSelecciona una opción [1-" + TipoConversion.values().length + "]: ");
        opcion = sc.nextInt();

        TipoConversion eleccion = TipoConversion.values()[opcion - 1];

        switch (eleccion){
            case METROS_PIES:
                System.out.println("\nIntroduce los metros: ");
                valor1 = sc.nextDouble();

                valor2 = valor1 * 3.28;

                System.out.println("\n" + String.format("%.2f", valor1) + " m = " + String.format("%.2f", valor2) + " pies");
                break;

            case PIES_METROS:
                System.out.println("\nIntroduce los pies: ");
                valor1 = sc.nextDouble();

                valor2 = valor1 * 0.30;

                System.out.println("\n" + String.format("%.2f", valor1) + " pies = " + String.format("%.2f", valor2) + " m");
                break;

            case CELSIUS_FARENHEIT:
                System.out.println("\nIntroduce la temperatura en celsius: ");
                valor1 = sc.nextDouble();

                valor2 = (valor1 * 9/5) + 32;

                System.out.println("\n" + String.format("%.2f", valor1) + " ºC = " + String.format("%.2f", valor2) + " ºF");
                break;

            case FARENHEIT_CELSIUS:
                System.out.println("\nIntroduce la temperatura en farenheit: ");
                valor1 = sc.nextDouble();

                valor2 = (valor1 - 32) * 5 / 9;

                System.out.println("\n" + String.format("%.2f", valor1) + " ºF = " + String.format("%.2f", valor2) + " ºC");
                break;
        }

    }
    enum TipoConversion{
        METROS_PIES, PIES_METROS, CELSIUS_FARENHEIT, FARENHEIT_CELSIUS
    }
}
