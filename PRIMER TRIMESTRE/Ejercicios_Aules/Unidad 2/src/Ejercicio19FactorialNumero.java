import java.util.Scanner;

public class Ejercicio19FactorialNumero {
    public static void main (String[] args){
        Scanner sc =  new Scanner(System.in);

        System.out.println("Ejercicio 19: Programa que solicita un número entero positivo y calcula su factorial");
        System.out.println("====================================================================================");

        int contador = 1;
        int numero;
        long factorial = 1;

        try {
            System.out.print("\nIntroduce un número: ");
            numero = sc.nextInt();

            System.out.print("\n!" + numero + " = ");

            for (int i = 1; i < numero + 1; i++){
                if(i <= numero){
                    System.out.print(contador);
                    contador++;
                    factorial *= i;
                }

                if(i <= numero - 1){
                    System.out.print(" x ");
                }
            }

            if(factorial <= Integer.MAX_VALUE){
                System.out.print(" = "+ factorial);

            }else{
                System.out.print(" = ERROR (Desbordamiento debido a que el factorial supera el valor máximo de INT)");
            }

        } catch (Exception e) {
            System.out.println("\nERROR: Tienes que introducir un número entero.");
        }
    }
}
