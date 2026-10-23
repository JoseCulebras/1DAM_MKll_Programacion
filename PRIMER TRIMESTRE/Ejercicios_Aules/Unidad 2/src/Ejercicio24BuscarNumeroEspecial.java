import java.util.Scanner;

public class Ejercicio24BuscarNumeroEspecial {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 24: Programa que solicitará un números al usuario (los negativos no se tienen en cuenta) y se irán contabilizando hasta introducir 10 números o introducir un 100");
        System.out.println("===========================================================================================================================================================================\n");

        int numero;
        int contador = 0;

        try {
            while(contador != 10){
                System.out.print("Introduce un número: ");
                numero = sc.nextInt();

                if(numero < 0){
                    System.out.println("El número es negativo. Se ignora.\n");
                    continue;
                }

                if(numero != 100){
                    contador++;
                }

                if(numero == 100){
                    System.out.println("\n¡Se ha encontrado el número especial 100!");
                    break;
                }
            }

            System.out.println("\nNúmeros positivos introducidos: " + contador);

        } catch (Exception e) {
            System.out.println("\nERROR: Solo puedes introducir números enteros.");
        }
    }
}
