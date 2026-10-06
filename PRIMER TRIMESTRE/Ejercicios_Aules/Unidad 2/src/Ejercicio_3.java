import java.util.Scanner;

public class Ejercicio_3 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 3: Programa que indica si los números enteros introducidos son divisibles o no");
        System.out.println("========================================================================================");

        int dividendo;
        int divisor;

        try {
            System.out.println("\nIntroduce el dividendo: ");
            dividendo = sc.nextInt();

            System.out.println("\nIntroduce el divisor: ");
            divisor = sc.nextInt();

            do{
                if(divisor == 0){
                    System.out.println("\nNo es posible dividir entre cero, introduce otro número: ");
                    divisor = sc.nextInt();
                }

            }while (divisor == 0);

            if(dividendo % divisor == 0){
                System.out.println("\nEl número " + dividendo + " es divisible por " + divisor);

            }else if(dividendo % divisor != 0){
                System.out.println("\nEl número " + dividendo + " NO es divisible por " + divisor);
            }

        }catch (Exception e){
            System.out.println("\nERROR: Solo se puede introducir números enteros.");
        }
    }
}
