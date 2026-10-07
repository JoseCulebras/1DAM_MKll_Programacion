import java.util.Scanner;

public class Ejercicio6PrecioIVA {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 6: Programa que pide un producto sin IVA y se lo aplica posteriormente");
        System.out.println("================================================================================");

        double precioProducto;
        double IVA = 0.21;
        double precioProductoIVA;

        try{
            System.out.println("\nIntroduce el precio de un producto: ");
            precioProducto = sc.nextDouble();

            precioProductoIVA = (precioProducto * IVA) + precioProducto;

            System.out.println("\nEl precio del producto aplicando un IVA del 21% es: " + String.format("%.2f", precioProductoIVA) + " €");

        }catch (Exception e){
            System.out.println("\nERROR: Tienes que introducir un número válido");
        }
    }
}
