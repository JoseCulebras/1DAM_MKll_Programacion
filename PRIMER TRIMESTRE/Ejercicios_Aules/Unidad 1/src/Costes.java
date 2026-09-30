import java.util.Scanner;

public class Costes {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        double precio;
        double impuestos;

        System.out.println("\n======");
        System.out.println("COSTES");
        System.out.println("======");

        System.out.println("\nIntroduce el precio: ");
        precio = sc.nextDouble();

        System.out.println("\nIntroduce los impuestos: ");
        impuestos = sc.nextDouble();

        precio = precio * (1 + impuestos/100);

        System.out.println("\nEl precio final es: " + precio);
    }
}
