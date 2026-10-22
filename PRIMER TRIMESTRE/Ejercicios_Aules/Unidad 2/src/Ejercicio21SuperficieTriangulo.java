import java.util.Scanner;

public class Ejercicio21SuperficieTriangulo {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 21: Programa que solicita al usuario la base y la altura del triángulo, comprueba que los dos valores son positivos, calcula la superficie y la muestra por pantalla.");
        System.out.println("===============================================================================================================================================================================");

        double base = 0;
        double altura = 0;
        double superficie;
        String respuesta;

        try {
            System.out.println("\n=======================");
            System.out.println("SUPERFICIE DE TRIÁNGULO");
            System.out.println("=======================");

            System.out.print("\nIntroduce la base: ");
            base = sc.nextDouble();

            System.out.print("Introduce la altura: ");
            altura = sc.nextDouble();

            superficie = (base * altura) / 2;

            System.out.println("\nSuperficie: " + superficie);

            do{
                System.out.print("\n¿Deseas realizar otro cálculo? (S/N): ");
                respuesta = sc.next();

                if(respuesta.equalsIgnoreCase("s")){
                    System.out.print("\nIntroduce la base: ");
                    base = sc.nextDouble();

                    System.out.print("Introduce la altura: ");
                    altura = sc.nextDouble();

                    superficie = (base * altura) / 2;

                    System.out.println("\nSuperficie: " + superficie);


                }else if(respuesta.equalsIgnoreCase("n")){
                    System.out.println("\nFin del programa.");
                }

            }while(base < 0 || altura < 0 || respuesta.equalsIgnoreCase("s"));

        } catch (Exception e) {
            System.out.println("\nERROR: debes introducir un número válido.");
        }
    }
}
