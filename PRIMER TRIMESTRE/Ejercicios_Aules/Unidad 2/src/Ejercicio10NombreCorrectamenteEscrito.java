import java.util.Scanner;

public class Ejercicio10NombreCorrectamenteEscrito {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 10: Programa que solicita un nombre y lo muestra poniendo la primera letra en mayúscula, las intermedias en minúscula y la última en mayúscula");
        System.out.println("========================================================================================================================================================");

        String nombre;
        String primeraLetra;
        String letrasIntermedias;
        String letraFinal;

        System.out.println("\nIntroduce tu nombre: ");
        nombre = sc.next();

        primeraLetra = String.valueOf(nombre.charAt(0));
        letrasIntermedias = nombre.substring(1, nombre.length() - 1);
        letraFinal = nombre.substring(nombre.length() - 1, nombre.length());

        primeraLetra = primeraLetra.toUpperCase();
        letrasIntermedias = letrasIntermedias.toLowerCase();
        letraFinal = letraFinal.toUpperCase();

        System.out.println("\nEl nombre modificado sería: " + primeraLetra + letrasIntermedias + letraFinal);
    }
}
