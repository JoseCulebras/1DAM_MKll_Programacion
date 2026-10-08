import java.util.Scanner;

public class Ejercicio9CalculadoraBasica {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 9: Programa que actúa como una calculadora básica con números enteros");
        System.out.println("===============================================================================");

        int a;
        int b;
        int opcion;

        System.out.println("\n------------------");
        System.out.println("CALCULADORA BÁSICA");
        System.out.println("------------------");
        System.out.println("- 1. Sumar       -");
        System.out.println("- 2. Restar      -");
        System.out.println("- 3. Multiplicar -");
        System.out.println("- 4. Dividir     -");
        System.out.println("------------------");

        System.out.println("\nIntroduce la opción que deseas: ");
        opcion = sc.nextInt();

        switch (opcion){
            case 1:
                System.out.println("\nIntroduce el primer número: ");
                a = sc.nextInt();

                System.out.println("\nIntroduce el segundo número: ");
                b = sc.nextInt();

                System.out.println("\nRESULTADO = " + (a + b));
                break;

            case 2:
                System.out.println("\nIntroduce el primer número: ");
                a = sc.nextInt();

                System.out.println("\nIntroduce el segundo número: ");
                b = sc.nextInt();

                System.out.println("\nRESULTADO = " + (a - b));
                break;

            case 3:
                System.out.println("\nIntroduce el primer número: ");
                a = sc.nextInt();

                System.out.println("\nIntroduce el segundo número: ");
                b = sc.nextInt();

                System.out.println("\nRESULTADO = " + (a * b));
                break;

            case 4:
                System.out.println("\nIntroduce el primer número: ");
                a = sc.nextInt();

                System.out.println("\nIntroduce el segundo número: ");
                b = sc.nextInt();

                while(b == 0){
                    System.out.println("\nERROR: No se puede dividir entre 0.");
                    System.out.println("Introduce un número válido: ");
                    b = sc.nextInt();
                }

                System.out.println("\nRESULTADO = " + (a / b));
                break;
        }

    }
}
