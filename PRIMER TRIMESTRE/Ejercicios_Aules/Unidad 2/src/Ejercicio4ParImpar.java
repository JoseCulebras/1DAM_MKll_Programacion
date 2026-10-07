import java.util.Scanner;

public class Ejercicio4ParImpar {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 4: Programa que indica si un número introducido es par o impar");
        System.out.println("========================================================================");

        int numero;
        String par_o_impar;
        String nombre;

        System.out.println("\n\nVamos a calcular si un número es par o impar");
        System.out.println("==============================================");

        try{
            System.out.println("\nIntroduce un número a determinar si es par o impar: ");
            numero = sc.nextInt();

            if(numero % 2 == 0){
                par_o_impar = "par";

            }else{
                par_o_impar = "impar";
            }

            sc.nextLine();

            System.out.println("\nIntroduce tu nombre: ");
            nombre = sc.nextLine();

            System.out.println("\n" + nombre + ", el número es " + par_o_impar);

        }catch (Exception e){
            System.out.println("\nERROR: Solo se pueden introducir números enteros.");
        }
    }
}
