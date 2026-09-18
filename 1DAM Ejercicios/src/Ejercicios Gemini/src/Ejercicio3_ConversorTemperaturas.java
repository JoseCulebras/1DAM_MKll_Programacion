import java.util.Scanner;

public class Ejercicio3_ConversorTemperaturas {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do{
            System.out.println("\n=========================================");
            System.out.println("=       Conversor de Temperaturas       =");
            System.out.println("=========================================");
            System.out.println("=   1. Convertir Celsius a Fahrenheit   =");
            System.out.println("=   2. Convertir Fahrenheit a Celsius   =");
            System.out.println("=   3. Salir                            =");
            System.out.println("=========================================");
            System.out.println("\nIntroduce la opción que quieras calcular: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("\nIntroduce los grados celsius que quieres pasar a fahrenheit: ");
                    double celsius = scanner.nextDouble();

                    System.out.println("\nRESULTADO: " + String.format("%.2f", celsiusAFahrenheit(celsius)) + " ºF");

                    break;

                case 2:
                    System.out.println("\nIntroduce los grados fahrenheit que quieres pasar a celsius: ");
                    double fahrenheit = scanner.nextDouble();

                    System.out.println("\nRESULTADO: " + String.format("%.2f", fahrenheitACelsius(fahrenheit)) + " ºC");

                    break;
            }
        }while(opcion != 3);

    }

    public static double celsiusAFahrenheit(double celsius){

        //formula para pasar de celsius a fahrenheit
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitACelsius(double fahrenheit){

        //formula para pasar de fahrenheit a celsius
        return (fahrenheit - 32) * 5 / 9;
    }
}