import java.util.Scanner;

public class Ejercicio5EntradaPartido {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 5: Programa que solicita la edad e indica el precio de la entrada");
        System.out.println("===========================================================================");

        int precio;
        int edad;
        String mensaje = "\nEl precio de la entrada es: ";
        String regalo = "";

        try{
            System.out.println("\nIntroduce tu edad: ");
            edad = sc.nextInt();

            do{
                System.out.println("\nIntroduce una edad superior a 0, inténtalo de nuevo: ");
                edad = sc.nextInt();

            }while(edad <= 0);

            if(edad < 5){

                System.out.println(mensaje + "GRATIS!!");

            }else if(edad <= 15){

                precio = 2;

                if(edad > 7 && edad < 10){
                    regalo = ", junto a una bolsa de chuches gratis!!";
                }

                System.out.println(mensaje + precio + " €" + regalo);

            }else{
                precio = 3;

                if(edad > 18 && edad < 30){
                    regalo = ", junto a una bebida gratis!!";
                }

                System.out.println(mensaje + precio + " €" + regalo);
            }

        }catch (Exception e){
            System.out.println("\nERROR: Introduce una edad válida (número entero)");
        }
    }
}
