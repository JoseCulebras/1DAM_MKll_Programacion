import java.util.Scanner;

public class TEST {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String primeraPalabraFrase;
        String primeraPalabraFraseLimpia;
        String segundaPalabraFrase;
        String segundaPalabraFraseLimpia;

        System.out.println("Ejercicio 34: Programa que solicita al usuario dos palabras o dos frases y determina si son anagramas");
        System.out.println("=====================================================================================================");

        System.out.print("\nIntroduzca la primera palabra o frase: ");
        primeraPalabraFrase = sc.nextLine();

        System.out.print("\nIntroduzca la segunda palabra o frase: ");
        segundaPalabraFrase = sc.nextLine();

        // Limpiar espacios y pasar a minúsculas
        primeraPalabraFraseLimpia = primeraPalabraFrase.toLowerCase().replace(" ", "");
        segundaPalabraFraseLimpia = segundaPalabraFrase.toLowerCase().replace(" ", "");

        // Requisito: Deben ser diferentes para considerarse anagramas
        if (primeraPalabraFraseLimpia.equals(segundaPalabraFraseLimpia)){
            System.out.println("\nLas palabras o frases deben ser diferentes.");
            return;
        }

        boolean sonAnagramas = true;

        // Si no tienen la misma longitud (sin contar espacios), ya no pueden ser anagramas
        if (primeraPalabraFraseLimpia.length() != segundaPalabraFraseLimpia.length()) {
            sonAnagramas = false;
        } else {
            // Array para contar la frecuencia de cada carácter (tabla ASCII)
            int[] frecuencias = new int[256];

            // Bucle para sumar las letras de la primera frase y restar las de la segunda
            for (int i = 0; i < primeraPalabraFraseLimpia.length(); i++) {
                char c1 = primeraPalabraFraseLimpia.charAt(i);
                char c2 = segundaPalabraFraseLimpia.charAt(i);

                frecuencias[c1]++;
                frecuencias[c2]--;
            }

            // Bucle para comprobar si todo ha quedado en ceros
            for (int i = 0; i < frecuencias.length; i++) {
                if (frecuencias[i] != 0) {
                    sonAnagramas = false;
                    break;
                }
            }
        }

        // Mostrar resultados según el formato solicitado en el ejercicio
        if (sonAnagramas) {
            if (primeraPalabraFrase.contains(" ") || segundaPalabraFrase.contains(" ")) {
                System.out.println("\nSon anagramas.");
            } else {
                System.out.println("\nSon palabras anagramas.");
            }
        } else {
            if (primeraPalabraFrase.contains(" ") || segundaPalabraFrase.contains(" ")) {
                System.out.println("\nNo son anagramas.");
            } else {
                System.out.println("\nNo son palabras anagramas.");
            }
        }
    }
}