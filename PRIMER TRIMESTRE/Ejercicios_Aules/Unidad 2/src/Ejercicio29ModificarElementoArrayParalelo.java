import java.util.Scanner;

public class Ejercicio29ModificarElementoArrayParalelo {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 29: Continuación del ejercicio 28, creando un programa que permita modificar el precio de un producto");
        System.out.println("===============================================================================================================");

        String[] nombreProductos = {"Pan", "Leche", "Arroz", "Huevos", "Aceite"};
        double[] precioProductos = {1.2, 1.15, 1.5, 2.1, 4.5};
        String producto;
        double nuevoPrecio;
        boolean encontrado = false;

        try {
            System.out.println("\n-----------------");
            System.out.println("-   PRODUCTOS   -");
            System.out.println("-----------------\n");

            for(int i = 0; i < nombreProductos.length; i++){
                System.out.printf("%-10s %6.2f €%n", nombreProductos[i], precioProductos[i]);

            }

            System.out.print("\nIntroduce el producto cuyo precio quieres modificar: ");
            producto = sc.nextLine();

            for(int i = 0; i < nombreProductos.length; i++){
                if(producto.equalsIgnoreCase(nombreProductos[i])){
                    encontrado = true;

                    System.out.print("\nIntroduce el nuevo precio (€): ");
                    nuevoPrecio = sc.nextDouble();

                    precioProductos[i] = nuevoPrecio;

                    System.out.println("\n-----------------------------");
                    System.out.println("-   PRODUCTOS MODIFICADOS   -");
                    System.out.println("-----------------------------");

                    for(i = 0; i < nombreProductos.length; i++){
                        System.out.printf("%-10s %6.2f €%n", nombreProductos[i], precioProductos[i]);
                    }
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
