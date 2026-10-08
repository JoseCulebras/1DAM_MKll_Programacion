import java.util.Scanner;

public class Ejercicio8AnyoBisiesto {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 8: Programa que determina si un año introducido es bisiesto");
        System.out.println("=====================================================================");

        int anyo = 0;

        System.out.println("\nIntroduce un año: ");
        anyo = sc.nextInt();

        if(anyo % 400 == 0 || anyo % 4 == 0 && anyo % 100 != 0){
            System.out.println("\nEl año " + anyo + " es bisiesto");

        }else{
            System.out.println("\nEl año NO es bisiesto");
        }
    }
}
