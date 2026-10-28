import java.util.Scanner;

public class Ejercicio28BuscarInformacionArraysParalelos {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 28: Programa que almacena 5 productos con nombre y precio, los cuales están almacenados en dos arrays paralelos");
        System.out.println("=========================================================================================================================");

        int numeroTotalProductos = 5;
        String[] nombreProductos = new String[numeroTotalProductos];
        double[] precioProductos = new double[numeroTotalProductos];
        int contadorProductos = 1;
        String producto;
        boolean encontrado = false;

        try {
            for(int i = 0; i < numeroTotalProductos; i++){

                System.out.println("\nProducto Nº" + (i + 1));
                System.out.print("Introduce el nombre: ");
                nombreProductos[i] = sc.nextLine();

                System.out.print("Introduce el precio (€): ");
                precioProductos[i] = sc.nextDouble();

                sc.nextLine();
            }

            System.out.println("\n-----------------");
            System.out.println("-   PRODUCTOS   -");
            System.out.println("-----------------");

            for(int i = 0; i < nombreProductos.length; i++){
                System.out.println("\nProducto " + contadorProductos);
                System.out.println("- Nombre: " + nombreProductos[i]);
                System.out.println("- Precio: " + String.format("%.2f", precioProductos[i]) + " €");
                contadorProductos++;
            }

            System.out.print("\nIntroduce el producto que quieres buscar: ");
            producto = sc.nextLine();

            for(int i = 0; i < nombreProductos.length; i++){
                if(producto.equalsIgnoreCase(nombreProductos[i])){
                    System.out.println("\nProducto encontrado: ");
                    System.out.println("- Nombre: " + nombreProductos[i]);
                    System.out.println("- Precio: " + String.format("%.2f", precioProductos[i]) + " €");
                    encontrado = true;
                }

                if(i == nombreProductos.length - 1 && !encontrado){
                    System.out.println("\nEl producto no existe.");
                }
            }

        } catch (Exception e) {
            System.out.println("\nERROR: Introduce un valor válido.");
        }
    }
}
