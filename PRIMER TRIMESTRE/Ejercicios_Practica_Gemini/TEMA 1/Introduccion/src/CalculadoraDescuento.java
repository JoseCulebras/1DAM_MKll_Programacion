import java.util.Scanner;

public class CalculadoraDescuento {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String nombreProducto = "";
        float precioOriginal = 0;
        float porcentaje = 0;
        float descuento = 0;
        float precioFinal = 0;

        System.out.println("\nIntroduce el nombre del producto: " );
        nombreProducto = sc.nextLine();

        System.out.println("\nIntroduce el precio original del producto: ");
        precioOriginal = sc.nextFloat();

        System.out.println("\nIntroduce el porcentaje de descuento a aplicar: ");
        porcentaje = sc.nextFloat();

        descuento = precioOriginal * (porcentaje / 100);

        precioFinal = precioOriginal - descuento;

        System.out.println("\n- NOMBRE DEL PRODUCTO: " + nombreProducto.toUpperCase());
        System.out.println("\n- PRECIO ORIGINAL: " + precioOriginal + " €");
        System.out.println("\n- AHORRO OBTENIDO: " + descuento + " €");
        System.out.println("\n- PRECIO FINAL: " + precioFinal + " €");
    }
}
