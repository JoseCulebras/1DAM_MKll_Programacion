import java.util.Scanner;

public class Ejercicio19FactorialNumero {
    public static void main (String[] args){
        Scanner sc =  new Scanner(System.in);

        System.out.println("Ejercicio 19: Programa que solicita un número entero positivo y calcula su factorial");
        System.out.println("====================================================================================");

        int numero;
        int factorial = 0;

        System.out.println("\nIntroduce un número entero positivo: ");
        numero = sc.nextInt();

        for(int i = 0; i < numero; i++){
            System.out.printf(String.valueOf(i + 1));

            if(i + 1 < numero){
                System.out.printf(" x ");
            }

//            factorial =* (i + 1);
        }

        System.out.println("\n\nRESULTADO: " + factorial);
    }
}
