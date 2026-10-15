import java.util.Scanner;

public class SistemaControlVentasInventario {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String[] productos = {"Teclado", "Ratón", "Monitor"};
        int[] stock = {10, 15, 5};
        double[] precios = {25.50, 12.00, 150.00};
        String codigoEmpleado = "";
        String regex = ("^[A-ZÑ]{1,2}-[0-9]{4}$");

        System.out.println("\nIntroduce un código de empleado: ");
        codigoEmpleado = sc.next();

        while(!codigoEmpleado.matches(regex)){
            System.out.println("\nCÓDIGO INVÁLIDO");
            System.out.println("Introduce un código válido: ");
            codigoEmpleado = sc.next();
        }

        do{
            System.out.println("\nNombre: " + productos + " | Stock: " + stock);
            System.out.printf("| Precio: " + precios);

        }while ();
    }
}
