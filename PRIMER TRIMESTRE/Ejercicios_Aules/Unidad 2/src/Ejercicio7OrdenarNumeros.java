import java.util.Scanner;

public class Ejercicio7OrdenarNumeros {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 7: Programa que pide tres números enteros y los ordena de menor a mayor");
        System.out.println("=================================================================================");

        int numero1;
        int numero2;
        int numero3;
        int primero = 0;
        int segundo = 0;
        int tercero = 0;

        try{
            System.out.println("Introduce el primer número: ");
            numero1 = sc.nextInt();

            System.out.println("Introduce el segundo número: ");
            numero2 = sc.nextInt();

            System.out.println("Introduce el tercer número: ");
            numero3 = sc.nextInt();

            if(numero1 > numero2 && numero2 > numero3){
                primero = numero1;
                segundo = numero2;
                tercero = numero3;

            }else if(numero1 > numero3 && numero3 > numero2) {
                primero = numero1;
                segundo = numero3;
                tercero = numero2;

            }else if(numero2 > numero1 && numero1 > numero3) {
                primero = numero2;
                segundo = numero1;
                tercero = numero3;

            }else if(numero2 > numero3 && numero3 > numero1) {
                primero = numero2;
                segundo = numero3;
                tercero = numero1;

            }else if(numero3 > numero1 && numero1 > numero2) {
                primero = numero3;
                segundo = numero1;
                tercero = numero2;

            }else if(numero3 > numero2 && numero2 > numero1) {
                primero = numero3;
                segundo = numero2;
                tercero = numero1;
            }

            System.out.println("\nLos números ordenados de menor a mayor son: ");
            System.out.println("Nº1= " + primero);
            System.out.println("Nº2= " + segundo);
            System.out.println("Nº3= " + tercero);

        }catch (Exception e){
            System.out.println("ERROR: Tienes que introducir un número entero.");
        }
    }
}
