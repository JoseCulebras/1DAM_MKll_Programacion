import java.util.Scanner;

public class Ejercicio1_CalculadoraDescuentos {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        double precioProducto = 0;
        int categoria = 0;
        double descuento = 0;

        System.out.println("\nEscribe el precio de un producto (€): ");
        precioProducto = scanner.nextDouble();

        System.out.println("\nEscribe la categoría del producto que quieres saber el precio");
        System.out.println("CATEGORÍAS: 1ºRopa | 2ºElectrónica | 3ºAlimentos");

        do{
            categoria = scanner.nextInt();

            if(categoria != 1 && categoria != 2 && categoria != 3){
                System.out.println("\nERROR");
                System.out.println("Número incorrecto introducido");
                System.out.println("\nIntroduce otro número: ");
            }
        }while(categoria != 1 && categoria != 2 && categoria != 3);



        switch (categoria){
            case 1:
                descuento = (precioProducto * 0.1);

                precioProducto = precioProducto - descuento;

                System.out.println("\nDescuento = 10%");
                System.out.println("El precio final con el descuento aplicado es: " + precioProducto + " €");
                break;

            case 2:
                descuento = (precioProducto * 0.2);

                precioProducto = precioProducto - descuento;

                System.out.println("\nDescuento = 20%");
                System.out.println("El precio final con el descuento aplicado es: " + precioProducto + " €");
                break;

            case 3:
                descuento = 0;

                precioProducto = precioProducto - descuento;

                System.out.println("\nDescuento = No tiene descuento");
                System.out.println("El precio final es: " + precioProducto + " €");
                break;
        }
    }
}