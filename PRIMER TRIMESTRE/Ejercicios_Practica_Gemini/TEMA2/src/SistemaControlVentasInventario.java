import java.util.Scanner;

public class SistemaControlVentasInventario {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String[] productos = {"Teclado", "Ratón", "Monitor"};
        int[] stock = {10, 15, 5};
        double[] precios = {25.50, 12.00, 150.00};
        String codigoEmpleado = "";
        String regex = ("^[A-ZÑ]{1,2}-[0-9]{4}$");
        int i = 0; //contador
        int indice;
        String mensaje = "\nIntroduce la cantidad que deseas vender: ";
        String mensajeError = "\nERROR: Introduce una cantidad superior a cero y que no supere el stock disponible: ";
        int cantidadVender;
        int cantidadVenderNueva;
        double totalPagar = 0;

        System.out.println("\nIntroduce un código de empleado: ");
        codigoEmpleado = sc.next();

        while(!codigoEmpleado.matches(regex)){
            System.out.println("\nCÓDIGO INVÁLIDO");
            System.out.println("Introduce un código válido: ");
            codigoEmpleado = sc.next();
        }

        System.out.println("\n---------------------INVENTARIO---------------------");

        do{
            System.out.println("\n" + i + ". Nombre: " + productos[i] + " | Precio: " + precios[i] + " € | Stock: " + stock[i]);
            i++;

        }while (i < productos.length);

        System.out.println("\n----------------------------------------------------");

        System.out.println("Introduce el índice del producto que deseas vender [0-" + (productos.length - 1) + "]: ");
        indice = sc.nextInt();

        switch (indice){
            case 0:
                System.out.println(mensaje);
                cantidadVender = sc.nextInt();

                while(cantidadVender <= 0 || cantidadVender > stock[indice]){
                    System.out.println(mensajeError);
                    cantidadVender = sc.nextInt();
                }

                cantidadVenderNueva = stock[indice] - cantidadVender;

                totalPagar = precios[indice] * cantidadVenderNueva;


                break;

            case 1:
                System.out.println(mensaje);
                cantidadVender = sc.nextInt();

                while(cantidadVender <= 0 || cantidadVender > stock[indice]){
                    System.out.println(mensajeError);
                    cantidadVender = sc.nextInt();
                }

                cantidadVenderNueva = stock[indice] - cantidadVender;

                totalPagar = precios[indice] * cantidadVenderNueva;

                break;

            case 2:
                System.out.println(mensaje);
                cantidadVender = sc.nextInt();

                while(cantidadVender <= 0 || cantidadVender > stock[indice]){
                    System.out.println(mensajeError);
                    cantidadVender = sc.nextInt();
                }

                cantidadVenderNueva = stock[indice] - cantidadVender;

                totalPagar = precios[indice] * cantidadVenderNueva;

                break;
        }

        System.out.println("\nEl total a pagar es: " + totalPagar + " €");

        System.out.println("\nMuchas gracias por tu tiempo.");
    }
}
